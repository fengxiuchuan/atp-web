package com.atp.service.impl.member;

import com.atp.common.GlobalConstants;
import com.atp.common.SerialNoGenerator;
import com.atp.dao.base.AtpCourseDao;
import com.atp.dao.coach.AtpCoachDao;
import com.atp.dao.member.AtpMemCourseDao;
import com.atp.dao.member.AtpMemberDao;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.coach.AtpCoachDTO;
import com.atp.dto.member.AtpMemCourseConsumeDTO;
import com.atp.dto.member.AtpMemCourseDTO;
import com.atp.entity.base.AtpCourse;
import com.atp.entity.coach.AtpCoach;
import com.atp.entity.member.AtpMemCourse;
import com.atp.entity.member.AtpMember;
import com.atp.exception.ATPException;
import com.atp.service.member.AtpMemCourseConsumeService;
import com.atp.service.member.AtpMemCourseService;
import com.atp.util.CommonUtil;
import com.atp.util.DoubleUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: AtpMemCourseService 实现类
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpMemCourseServiceImpl implements AtpMemCourseService {

    @Autowired
    private AtpMemCourseDao atpMemCourseDao;

    @Resource
    private AtpMemCourseConsumeService atpMemCourseConsumeService;

    @Autowired
    private AtpCoachDao atpCoachDao;

    @Autowired
    private AtpCourseDao atpCourseDao;

    @Autowired
    private AtpMemberDao atpMemberDao;

    @Override
    @Transactional(readOnly = true)
    public AtpMemCourse getById(Long id) {
        if (id == null) {
            return null;
        }
        return atpMemCourseDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<AtpMemCourse> queryList(AtpMemCourseDTO dto)  {
        if (dto == null) {
            return null;
        }
        return atpMemCourseDao.queryList(dto);
    }
    


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(AtpMemCourse record)  {
        if (record == null) {
            return 0;
        }
        return atpMemCourseDao.save(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveBatch(List<AtpMemCourse> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpMemCourseDao.saveBatch(recordList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateById(AtpMemCourse record)  {
        if (record == null) {
            return 0;
        }
        return atpMemCourseDao.updateByPrimaryKey(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpMemCourseDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpMemCourseDao.deleteBatchByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void payCourse(AtpMemCourseDTO atpMemCourseDTO) throws ATPException {
        //1 校验
        List<AtpMemCourse> memCourseList =  validateAndParsePayCourse(atpMemCourseDTO);
        //2 保存
        if(CollectionUtils.isEmpty(memCourseList)){
            return;
        }
        Long memId =  atpMemCourseDTO.getMemId();
        AtpMember atpMember = atpMemberDao.selectByPrimaryKey(memId);
        if(Objects.isNull(atpMember)){
            throw new ATPException("未找到此学员");
        }
        String cardNo = atpMember.getCardNo();
        Double originTotalBuy = atpMember.getTotalBuy() == null ? 0D: atpMember.getTotalBuy();
        Double totalBuy = 0D;
        for(AtpMemCourse atpMemCourse : memCourseList){
            String orderNo = CommonUtil.createOrderNo(GlobalConstants.MEM_ORDER_SERIID, SerialNoGenerator.Cycle.MONTHLY,GlobalConstants.MEM_ORDER_NO_PREFIX,4);
            atpMemCourse.setOrderNo(orderNo);
            atpMemCourse.setMemId(memId);
            atpMemCourse.setCardNo(cardNo);

            totalBuy = DoubleUtil.add(totalBuy,atpMemCourse.getCourseAmount());
        }
        atpMemCourseDao.saveBatch(memCourseList);

        Double newTotalBuy = DoubleUtil.add(totalBuy,originTotalBuy);
        AtpMember tempMem = new AtpMember();
        tempMem.setId(memId);
        tempMem.setTotalBuy(newTotalBuy);
        tempMem.setLastUpdatedBy(-1L);
        tempMem.setLastUpdatedTime(new Date());
        tempMem.setLastUpdatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpMemberDao.updateByPrimaryKeySelective(tempMem);

    }

    private List<AtpMemCourse> validateAndParsePayCourse(AtpMemCourseDTO atpMemCourseDTO)  throws ATPException{
        if(Objects.isNull(atpMemCourseDTO)){
            throw new ATPException("请求参数为空");
        }
        Long memId =  atpMemCourseDTO.getMemId();
        if(Objects.isNull(memId)){
            throw new ATPException("请选择需要充值的会员");
        }
        Long [] courseIdArr = atpMemCourseDTO.getCourseIdArr();
        Long [] coachIdArr = atpMemCourseDTO.getCoachIdArr();
        Integer [] totalNumArr = atpMemCourseDTO.getTotalNumArr();
        Double[] courseAmountArr = atpMemCourseDTO.getCourseAmountArr();
        if(ArrayUtils.isEmpty(courseIdArr) || ArrayUtils.isEmpty(coachIdArr)|| ArrayUtils.isEmpty(totalNumArr)|| ArrayUtils.isEmpty(courseAmountArr)){
            throw new ATPException("请填写充值的课程");
        }
        int length = courseIdArr.length;
        List<AtpMemCourse> memCourseList = new ArrayList<AtpMemCourse>();
        List<AtpCourseDTO> courseList = atpCourseDao.queryGymCourseList(1L);
        List<AtpCoachDTO> coachList = atpCoachDao.getCoachList(1L);

        for (int i = 0; i < length; i++) {
            StringBuffer errorMsg = new StringBuffer();
            Long courseId = courseIdArr[i];
            Long coachId = coachIdArr[i];
            Integer totalNum = totalNumArr[i];
            Double courseAmount = courseAmountArr[i];
            if(Objects.isNull(courseId)){
                errorMsg.append("请选择课程;");
            }
            if(Objects.isNull(coachId)){
                errorMsg.append("请选择课程教练;");
            }
            if(Objects.isNull(totalNum)){
                errorMsg.append("请输入充值课时;");
            }
            if(Objects.isNull(courseAmount)){
                errorMsg.append("请输入充值课时金额;");
            }
            if(StringUtils.isNotBlank(errorMsg.toString())){
                errorMsg.insert(0,"充值课程第"+(i + 1)+"行：");
                throw new ATPException(errorMsg.toString());
            }

            AtpCourse atpCourse = getCourseById(courseIdArr[i],courseList);
            AtpCoach atpCoach = getCoacById(coachIdArr[i],coachList);
            if(Objects.isNull(atpCourse) || Objects.isNull(atpCoach)){
                throw new ATPException("场馆教练或者课程为空");
            }
            AtpMemCourse atpMemCourse = new AtpMemCourse("","",null,atpCourse.getId(),atpCourse.getCourseName(),atpCoach.getId(),atpCoach.getCoachNo(),totalNumArr[i], DoubleUtil.roundDouble(courseAmountArr[i],5));
            atpMemCourse.setFreeNum(totalNumArr[i]);
            atpMemCourse.setUsedNum(0);
            atpMemCourse.setCreatedBy(-1L);
            atpMemCourse.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
            atpMemCourse.setCreatedTime(new Date());
            memCourseList.add(atpMemCourse);
        }
        return memCourseList;
    }
    private AtpCoach getCoacById(Long coachId, List<AtpCoachDTO> coachList) {
        if(Objects.isNull(coachId) || CollectionUtils.isEmpty(coachList)){
            return null;
        }
        return coachList.stream().filter(atpCoachDTO -> Objects.equals(coachId,atpCoachDTO.getId())).collect(Collectors.toList()).get(0);
    }

    private AtpCourse getCourseById(Long courseId, List<AtpCourseDTO> sourceCourseList) throws ATPException{
        if(Objects.isNull(courseId) || CollectionUtils.isEmpty(sourceCourseList)){
            return null;
        }
        return sourceCourseList.stream().filter(atpCourseDTO -> Objects.equals(courseId,atpCourseDTO.getId())).collect(Collectors.toList()).get(0);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void consumeCourse(AtpMemCourseConsumeDTO consumeDTO) {
        consumeDTO.setCreatedBy(GlobalConstants.SUPER_ADMIN_ID);
        consumeDTO.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
        consumeDTO.setCreatedTime(new Date());
        consumeDTO.setConsumeTime(new Date());
        atpMemCourseConsumeService.save(consumeDTO);
    }

}
