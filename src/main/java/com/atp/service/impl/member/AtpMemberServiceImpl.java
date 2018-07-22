package com.atp.service.impl.member;

import com.atp.common.GlobalConstants;
import com.atp.common.SerialNoGenerator;
import com.atp.dao.base.AtpCourseDao;
import com.atp.dao.coach.AtpCoachDao;
import com.atp.dao.member.AtpMemCourseDao;
import com.atp.dao.member.AtpMemberDao;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.base.response.BasePageResponse;
import com.atp.dto.coach.AtpCoachDTO;
import com.atp.dto.member.AtpMemCourseConsumeDTO;
import com.atp.dto.member.AtpMemCourseDTO;
import com.atp.dto.member.AtpMemberDTO;
import com.atp.entity.base.AtpCourse;
import com.atp.entity.coach.AtpCoach;
import com.atp.entity.member.AtpMemCourse;
import com.atp.entity.member.AtpMember;
import com.atp.exception.ATPException;
import com.atp.service.member.AtpMemberService;
import com.atp.util.CommonUtil;
import com.atp.util.DoubleUtil;
import com.atp.util.MD5Util;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: AtpMemberService 实现类
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:29
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpMemberServiceImpl implements AtpMemberService {

    @Autowired
    private AtpMemberDao atpMemberDao;

    @Autowired
    private AtpCourseDao atpCourseDao;

    @Autowired
    private AtpCoachDao atpCoachDao;

    @Autowired
    private AtpMemCourseDao atpMemCourseDao;

    @Override
    @Transactional(readOnly = true)
    public AtpMember getById(Long id) {
        if (id == null) {
            return null;
        }
        return atpMemberDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<AtpMember> queryList(AtpMemberDTO dto)  {
        if (dto == null) {
            return null;
        }
        return atpMemberDao.queryList(dto);
    }
    


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(AtpMember record)  {
        if (record == null) {
            return 0;
        }
        return atpMemberDao.save(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveBatch(List<AtpMember> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpMemberDao.saveBatch(recordList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateById(AtpMember record)  {
        if (record == null) {
            return 0;
        }
        return atpMemberDao.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpMemberDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpMemberDao.deleteBatchByIds(ids);
    }

    /**
     *
     * 功能描述: 校验提交表单
     *
     */
    private void validateForm(AtpMemberDTO atpMemberDTO,String submitFormType) throws ATPException{
        //7 会员唯一性校验
        Long id = null;
        if(StringUtils.isNotBlank(submitFormType) && Objects.equals(GlobalConstants.SUBMIT_FORM_TYPE.EDIT.getCode(),submitFormType)){
            id = atpMemberDTO.getId();
        }
        //1 姓名
        if(StringUtils.isBlank(atpMemberDTO.getName())){
            throw new ATPException("请填写会员姓名");
        }
        //2 性别
        if(Objects.isNull(atpMemberDTO.getSex())){
            throw new ATPException("请填写会员性别");
        }
        //3 年龄
        if(Objects.isNull(atpMemberDTO.getAge())){
            throw new ATPException("请填写会员年龄");
        }
        // 出生日期
        if(Objects.isNull(atpMemberDTO.getAge())){
            throw new ATPException("请填写会员出生日期");
        }

        if(StringUtils.isBlank(atpMemberDTO.getIdCard())){
            throw new ATPException("请填写身份证号码");
        }
        //4 联系方式
        if(StringUtils.isBlank(atpMemberDTO.getPhone())){
            throw new ATPException("请填写联系方式");
        }

        List<AtpMemberDTO> memberDTOList = atpMemberDao.queryListByPhone(atpMemberDTO.getPhone(),id);
        if(CollectionUtils.isNotEmpty(memberDTOList)){
            throw new ATPException("该手机已经存在，请重新填写");
        }

        //5 会员卡号
        if(StringUtils.isEmpty(atpMemberDTO.getCardNo())){
            throw new ATPException("请填写会员卡号");
        }
        //6 会员密码
        if(StringUtils.isBlank(atpMemberDTO.getCardPwd())){
            throw new ATPException("请填写会员密码");
        }

        memberDTOList = atpMemberDao.queryListByCardNo(atpMemberDTO.getCardNo(),id);
        if(CollectionUtils.isNotEmpty(memberDTOList)){
            throw new ATPException("该会员卡号已使用，请重新填写");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addMem(AtpMemberDTO atpMemberDTO) throws ATPException {
        //1 校验
        validateForm(atpMemberDTO,GlobalConstants.SUBMIT_FORM_TYPE.ADD.getCode());
        // 密码加密
        String userPwd = atpMemberDTO.getCardPwd();
        userPwd = MD5Util.encrypt(userPwd);
        if(StringUtils.isBlank(userPwd)){
            throw new ATPException("密码加密失败");
        }
        atpMemberDTO.setCardPwd(userPwd);
        //2 保存
        atpMemberDTO.setCreatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpMemberDTO.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpMemberDTO.setCreatedTime(new Date());
        atpMemberDao.save(atpMemberDTO);

        Long memberId = atpMemberDTO.getId();
        String cardNo = atpMemberDTO.getCardNo();

        Long [] courseIdArr = atpMemberDTO.getCourseIdArr();
        Long [] coachIdArr = atpMemberDTO.getCoachIdArr();
        Integer [] totalNumArr  = atpMemberDTO.getTotalNumArr();
        BigDecimal [] unitPriceArr = atpMemberDTO.getUnitPriceArr();
        BigDecimal [] discountAmountArr = atpMemberDTO.getDiscountAmountArr();
        if(ArrayUtils.isNotEmpty(courseIdArr)){
            List<AtpMemCourse> memCourseList = new ArrayList<AtpMemCourse>();
            Double totalBuy = 0D;
            //todo 将场馆替换为当前用户所属场馆
            List<AtpCourseDTO> courseList = atpCourseDao.queryGymCourseList(1L);
            List<AtpCoachDTO> coachList = atpCoachDao.getCoachList(1L);
            int length = courseIdArr.length;
            for (int i = 0; i < length; i++) {
                String orderNo = CommonUtil.createOrderNo(GlobalConstants.MEM_ORDER_SERIID,SerialNoGenerator.Cycle.MONTHLY,GlobalConstants.MEM_ORDER_NO_PREFIX,4);
                AtpCourse atpCourse = getCourseById(courseIdArr[i],courseList);
                AtpCoach atpCoach = getCoacById(coachIdArr[i],coachList);
                if(Objects.isNull(atpCourse) || Objects.isNull(atpCoach)){
                    throw new ATPException("场馆教练或者课程为空");
                }
                BigDecimal unitPrice = unitPriceArr[i];
                BigDecimal discountAmount = discountAmountArr[i];
                Integer totalNum = totalNumArr[i];
                Double totalPrice =   DoubleUtil.mul(unitPrice,Double.valueOf(String.valueOf(totalNum)));
                Double actualAmount = DoubleUtil.sub(totalPrice,discountAmount == null ? 0D:Double.valueOf(String.valueOf(discountAmount)));
                AtpMemCourse atpMemCourse = new AtpMemCourse(orderNo,cardNo,memberId,atpCourse.getId(),atpCourse.getCourseName(),atpCoach.getId(),atpCoach.getCoachNo(),totalNumArr[i], new BigDecimal(String.valueOf(totalPrice)),unitPrice,new BigDecimal(String.valueOf(actualAmount)),discountAmount);
                atpMemCourse.setFreeNum(totalNumArr[i]);
                atpMemCourse.setUsedNum(0);
                atpMemCourse.setCreatedBy(-1L);
                atpMemCourse.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
                atpMemCourse.setCreatedTime(new Date());
                atpMemCourseDao.save(atpMemCourse);
                totalBuy = DoubleUtil.add(totalPrice,totalBuy);
            }

            // 更新最新的
            AtpMember atpMember = new AtpMember();
            atpMember.setId(memberId);
            atpMember.setTotalBuy(totalBuy);
            atpMember.setLastUpdatedBy(-1L);
            atpMember.setLastUpdatedTime(new Date());
            atpMember.setLastUpdatedName(GlobalConstants.SUPER_ADMIN_NAME);
            atpMemberDao.updateByPrimaryKeySelective(atpMember);
        }
    }

    private AtpCoach getCoacById(Long coachId, List<AtpCoachDTO> coachList) {
        if(Objects.isNull(coachId) || CollectionUtils.isEmpty(coachList)){
            return null;
        }
        return coachList.stream().filter(atpCoachDTO -> Objects.equals(coachId,atpCoachDTO.getId())).collect(Collectors.toList()).get(0);
    }

    private AtpCourse getCourseById(Long courseId,List<AtpCourseDTO> sourceCourseList) throws ATPException{
        if(Objects.isNull(courseId) || CollectionUtils.isEmpty(sourceCourseList)){
            return null;
        }
        return sourceCourseList.stream().filter(atpCourseDTO -> Objects.equals(courseId,atpCourseDTO.getId())).collect(Collectors.toList()).get(0);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMem(AtpMemberDTO atpMemberDTO) throws ATPException {
        //1 校验
        validateForm(atpMemberDTO,GlobalConstants.SUBMIT_FORM_TYPE.ADD.getCode());
        //2 更新
        AtpMember atpMember = new AtpMember(atpMemberDTO.getName(),atpMemberDTO.getSex(),atpMemberDTO.getAge(),atpMemberDTO.getPhone(),atpMemberDTO.getAddress(),atpMemberDTO.getRemark(),atpMemberDTO.getCardPwd());
        atpMember.setBirth(atpMemberDTO.getBirth());
        atpMember.setId(atpMemberDTO.getId());
        atpMember.setLastUpdatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpMember.setLastUpdatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpMember.setLastUpdatedTime(new Date());
        atpMemberDao.updateById(atpMember);
    }

    @Override
    public List<AtpMemCourseDTO> queryCourseListByMemId(Long memberId) throws ATPException {
        if(Objects.isNull(memberId)){
            return null;
        }
        List<AtpMemCourseDTO> memCourseDTOList =  atpMemberDao.queryCourseListByMemId(memberId);
        if(!CollectionUtils.isEmpty(memCourseDTOList)){
            List<AtpCoachDTO> atpCoachList =  atpCoachDao.getCourseCoachsByGymId(null);
            for(AtpMemCourseDTO memCourseDTO : memCourseDTOList){
                if(Objects.isNull(memCourseDTO) || Objects.isNull(memCourseDTO.getCourseId())){
                    continue;
                }
                List<AtpCoachDTO> curCoachList = getCoachListByCourseId(memCourseDTO.getCourseId(),atpCoachList);
                memCourseDTO.setCoachList(curCoachList);
            }
        }
        return memCourseDTOList;
    }
    private List<AtpCoachDTO> getCoachListByCourseId(Long courseId,List<AtpCoachDTO> sourceCoachList) throws ATPException{
        if(Objects.isNull(courseId) || CollectionUtils.isEmpty(sourceCoachList)){
            return null;
        }
        return  sourceCoachList.stream().filter(atpCoachDTO -> Objects.equals(atpCoachDTO.getCourseId(),courseId)).collect(Collectors.toList());
    }
    @Override
    public BasePageResponse<AtpMemberDTO> queryAllList(AtpMemberDTO atpMemberDTO) throws ATPException {
        Page<Object> page = PageHelper.startPage(atpMemberDTO.getPage(), atpMemberDTO.getPageSize(), StringUtils.isBlank(atpMemberDTO.getOrderBy()) ? "":atpMemberDTO.getOrderBy());
        List<AtpMemberDTO> list = atpMemberDao.queryAllList(atpMemberDTO);
        BasePageResponse<AtpMemberDTO> response = new BasePageResponse<AtpMemberDTO>();


        if (list != null) {
            response.setRows(list);
            response.setTotal((int) page.getTotal());
            response.setTotalPage(atpMemberDTO.getPageSize());
        }

        return response;
    }

    @Override
    public List<AtpMember> getMemberList() throws ATPException {
        return atpMemberDao.getMemberList();
    }

    @Override
    public BasePageResponse<AtpMemCourseDTO> queryMemCourseList(AtpMemCourseDTO memCourseDTO) throws ATPException {
        Page<Object> page = PageHelper.startPage(memCourseDTO.getPage(), memCourseDTO.getPageSize(), StringUtils.isBlank(memCourseDTO.getOrderBy()) ? "":memCourseDTO.getOrderBy());
        List<AtpMemCourseDTO> list = atpMemberDao.queryMemCourseList(memCourseDTO);
        BasePageResponse<AtpMemCourseDTO> response = new BasePageResponse<AtpMemCourseDTO>();


        if (list != null) {
            response.setRows(list);
            response.setTotal((int) page.getTotal());
            response.setTotalPage(memCourseDTO.getPageSize());
        }

        return response;
    }

    @Override
    public BasePageResponse<AtpMemCourseConsumeDTO> queryConsumeList(AtpMemCourseConsumeDTO consumeDTO) throws ATPException {
        Page<Object> page = PageHelper.startPage(consumeDTO.getPage(), consumeDTO.getPageSize(), StringUtils.isBlank(consumeDTO.getOrderBy()) ? "":consumeDTO.getOrderBy());
        List<AtpMemCourseConsumeDTO> list = atpMemberDao.queryConsumeList(consumeDTO);
        BasePageResponse<AtpMemCourseConsumeDTO> response = new BasePageResponse<AtpMemCourseConsumeDTO>();


        if (list != null) {
            response.setRows(list);
            response.setTotal((int) page.getTotal());
            response.setTotalPage(consumeDTO.getPageSize());
        }

        return response;
    }
}
