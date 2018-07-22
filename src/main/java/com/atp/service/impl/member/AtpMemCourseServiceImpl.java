package com.atp.service.impl.member;

import com.atp.common.GlobalConstants;
import com.atp.common.SerialNoGenerator;
import com.atp.dao.base.AtpCourseDao;
import com.atp.dao.coach.AtpCoachDao;
import com.atp.dao.member.AtpMemCourseConsumeDao;
import com.atp.dao.member.AtpMemCourseDao;
import com.atp.dao.member.AtpMemberDao;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.coach.AtpCoachDTO;
import com.atp.dto.member.AtpMemCourseConsumeDTO;
import com.atp.dto.member.AtpMemCourseDTO;
import com.atp.entity.base.AtpCourse;
import com.atp.entity.coach.AtpCoach;
import com.atp.entity.member.AtpMemCourse;
import com.atp.entity.member.AtpMemCourseConsume;
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
import java.math.BigDecimal;
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
    private AtpMemCourseConsumeDao atpMemCourseConsumeDao;

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
        String cardNo = atpMemCourseDTO.getCardNo();
        String memName = atpMemCourseDTO.getMemName();
        AtpMember atpMember = atpMemberDao.selectByPrimaryKey(memId);
        if(Objects.isNull(atpMember)){
            throw new ATPException("未找到此学员");
        }

        Double originTotalBuy = atpMember.getTotalBuy() == null ? 0D: atpMember.getTotalBuy();
        Double totalBuy = 0D;
        for(AtpMemCourse atpMemCourse : memCourseList){
            String orderNo = CommonUtil.createOrderNo(GlobalConstants.MEM_ORDER_SERIID, SerialNoGenerator.Cycle.MONTHLY,GlobalConstants.MEM_ORDER_NO_PREFIX,4);
            atpMemCourse.setOrderNo(orderNo);
            atpMemCourse.setMemId(memId);
            atpMemCourse.setCardNo(cardNo);
            atpMemCourse.setMemName(memName);
            totalBuy = DoubleUtil.add(totalBuy,Double.valueOf(String.valueOf(atpMemCourse.getCourseAmount())));
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
        BigDecimal [] unitPriceArr = atpMemCourseDTO.getUnitPriceArr();
        BigDecimal [] discountAmountArr = atpMemCourseDTO.getDiscountAmountArr();
        String[]courseNameArr = atpMemCourseDTO.getCourseNameArr();
        String[] coachNoArr  = atpMemCourseDTO.getCoachNoArr();
        String[] coachNameArr = atpMemCourseDTO.getCoachNameArr();
        if(ArrayUtils.isEmpty(courseIdArr) || ArrayUtils.isEmpty(coachIdArr)|| ArrayUtils.isEmpty(totalNumArr)|| ArrayUtils.isEmpty(unitPriceArr)){
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
            BigDecimal unitPrice = unitPriceArr[i];
            BigDecimal discountAmount = discountAmountArr[i];
            if(Objects.isNull(courseId)){
                errorMsg.append("请选择课程;");
            }
            if(Objects.isNull(coachId)){
                errorMsg.append("请选择课程教练;");
            }
            if(Objects.isNull(unitPrice)){
                errorMsg.append("请输入课程单价;");
            }
            if(Objects.isNull(totalNum)){
                errorMsg.append("请输入充值课时;");
            }

            if(StringUtils.isNotBlank(errorMsg.toString())){
                errorMsg.insert(0,"充值课程第"+(i + 1)+"行：");
                throw new ATPException(errorMsg.toString());
            }

            Double totalPrice =   DoubleUtil.mul(unitPrice,Double.valueOf(String.valueOf(totalNum)));
            Double actualAmount = DoubleUtil.sub(totalPrice,discountAmount == null ? 0D:Double.valueOf(String.valueOf(discountAmount)));
            AtpMemCourse atpMemCourse = new AtpMemCourse("","",null,courseIdArr[i],courseNameArr[i],coachIdArr[i],coachNoArr[i],totalNumArr[i], new BigDecimal(String.valueOf(totalPrice)),unitPrice,new BigDecimal(String.valueOf(actualAmount)),discountAmount);
            atpMemCourse.setCoachName(coachNameArr[i]);
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
    public void consumeCourse(AtpMemCourseConsumeDTO consumeDTO)  throws ATPException{
        // 1 校验 解析
        List<AtpMemCourseConsume> consumeDTOList = validateAndParseConsumeCourse(consumeDTO);
        // 2 保存销课记录
        if(CollectionUtils.isEmpty(consumeDTOList)){
            return;
        }
        Long memId = consumeDTO.getMemId();
        AtpMember member = atpMemberDao.selectByPrimaryKey(memId);
        Double totalConsume = 0D;
        Integer integral = 0;
        for(AtpMemCourseConsume memCourseConsume : consumeDTOList){
            Long memCourseId = memCourseConsume.getMemCourseId();
            Integer courseNum = memCourseConsume.getCourseNum();
            BigDecimal unitPrice = memCourseConsume.getUnitPrice();
            Double consumePrice = DoubleUtil.mul(unitPrice,Double.valueOf(courseNum.doubleValue()));
            String consumeNo = CommonUtil.createOrderNo(GlobalConstants.MEM_COURSE_CONSUME_NO, SerialNoGenerator.Cycle.MONTHLY,GlobalConstants.MEM_CONSUME_NO_PREFIX,5);
            memCourseConsume.setConsumeNo(consumeNo);
            // 保存当前的
            atpMemCourseConsumeDao.save(memCourseConsume);

            // 更新对应所报课程的课时
            AtpMemCourse atpMemCourse = atpMemCourseDao.selectByPrimaryKey(memCourseId);
            Integer totalNum =  Objects.isNull(atpMemCourse.getTotalNum())? 0 : atpMemCourse.getTotalNum();
            Integer usedNum = Objects.isNull(atpMemCourse.getUsedNum())? 0 : atpMemCourse.getUsedNum() ;
            usedNum += courseNum;
            Integer freeNum = totalNum - usedNum;
            AtpMemCourse tempMemCourse = new AtpMemCourse();
            tempMemCourse.setId(memCourseId);
            tempMemCourse.setFreeNum(freeNum);
            tempMemCourse.setUsedNum(usedNum);
            atpMemCourseDao.updateByPrimaryKeySelective(tempMemCourse);


            //累加消耗金额和积分
            totalConsume = DoubleUtil.add(totalConsume,consumePrice);
            integral = integral + memCourseConsume.getIntegral();



        }
        // 计算积分和总管
        integral = integral + (member.getTotalIntegral() == null ? 0 :  member.getTotalIntegral());
        totalConsume =  DoubleUtil.add(totalConsume,member.getTotalConsume() == null ? 0D : member.getTotalConsume());

        //3 更新用户累计消费金额
        AtpMember tempMem = new AtpMember();
        tempMem.setId(memId);
        tempMem.setTotalConsume(totalConsume);
        tempMem.setTotalIntegral(integral);
        atpMemberDao.updateByPrimaryKeySelective(tempMem);

    }

    private List<AtpMemCourseConsume>  validateAndParseConsumeCourse(AtpMemCourseConsumeDTO consumeDTO) throws ATPException {
        if(Objects.isNull(consumeDTO)){
            throw new ATPException("请求参数为空");
        }
        Long memId =  consumeDTO.getMemId();
        String memCardNo = consumeDTO.getMemCardNo();
        String memName = consumeDTO.getMemName();
        if(Objects.isNull(memId)){
            throw new ATPException("请选择需要充值的会员");
        }

        Long [] memCourseIdArr = consumeDTO.getMemCourseIdArr();
        Long [] courseIdArr = consumeDTO.getCourseIdArr();
        String [] courseNameArr = consumeDTO.getCourseNameArr();
        Long [] coachIdArr = consumeDTO.getCoachIdArr();
        String [] coachNoArr = consumeDTO.getCoachNoArr();
        String [] coachNameArr = consumeDTO.getCoachNameArr();
        Integer []courseNumArr = consumeDTO.getCourseNumArr();
        Integer []integralArr = consumeDTO.getIntegralArr();
        Long []execCoachIdArr = consumeDTO.getExecCoachIdArr();
        String []execCoachNoArr = consumeDTO.getExecCoachNoArr();
        String []execCoachNameArr = consumeDTO.getExecCoachNameArr();
        BigDecimal[] unitPriceArr = consumeDTO.getUnitPriceArr();
        if(ArrayUtils.isEmpty(courseIdArr) || ArrayUtils.isEmpty(coachIdArr)|| ArrayUtils.isEmpty(execCoachIdArr)|| ArrayUtils.isEmpty(integralArr) || ArrayUtils.isEmpty(courseNumArr)){
            throw new ATPException("请填写充值的课程");
        }
        int length = courseIdArr.length;
        List<AtpMemCourseConsume> consumeDTOList = new ArrayList<AtpMemCourseConsume>();
        Date now = new Date();
        for (int i = 0; i < length; i++) {
            StringBuffer errorMsg = new StringBuffer();
            Long memCourseId = memCourseIdArr[i];
            Long courseId = courseIdArr[i];
            String courseName= courseNameArr[i];
            Long coachId = coachIdArr[i];
            String coachNo = coachNoArr[i];
            String coachName = coachNameArr[i];
            Long execCoachId = execCoachIdArr[i];
            String execCoachNo = execCoachNoArr[i];
            String execCoachName = execCoachNameArr[i];
            Integer courseNum = courseNumArr[i];
            Integer interal = integralArr[i];
            BigDecimal unitPrice = unitPriceArr[i];

            if(Objects.isNull(courseId)){
                errorMsg.append("请选择课程;");
            }
            if(Objects.isNull(coachId)){
                errorMsg.append("请选择课程执行教练;");
            }
            if(Objects.isNull(courseNum)){
                errorMsg.append("请输入消耗课时;");
            }
            if(Objects.isNull(interal)){
                errorMsg.append("请输入消费积分;");
            }
            if(StringUtils.isNotBlank(errorMsg.toString())){
                errorMsg.insert(0,"充值课程第"+(i + 1)+"行：");
                throw new ATPException(errorMsg.toString());
            }
            AtpMemCourseConsume memCourseConsume = new AtpMemCourseConsume(courseId,memCardNo,memCourseId,courseId,courseName,coachId,coachNo,coachName,execCoachId,execCoachNo,execCoachName,courseNum,interal);
            memCourseConsume.setMemName(memName);
            memCourseConsume.setUnitPrice(unitPrice);
            memCourseConsume.setConsumeTime(now);
            memCourseConsume.setCreatedBy(-1L);
            memCourseConsume.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
            memCourseConsume.setCreatedTime(now);
            consumeDTOList.add(memCourseConsume);
        }
        return  consumeDTOList;
    }

}
