package com.atp.service.impl.member;

import com.atp.common.GlobalConstants;
import com.atp.dao.member.AtpMemberDao;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.base.response.BasePageResponse;
import com.atp.dto.member.AtpMemberDTO;
import com.atp.entity.member.AtpMember;
import com.atp.exception.ATPException;
import com.atp.service.member.AtpMemberService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
        return atpMemberDao.updateByPrimaryKey(record);
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
        //2 保存
        atpMemberDTO.setCreatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpMemberDTO.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpMemberDTO.setCreatedTime(new Date());
        atpMemberDao.save(atpMemberDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMem(AtpMemberDTO atpMemberDTO) throws ATPException {
        //1 校验
        validateForm(atpMemberDTO,GlobalConstants.SUBMIT_FORM_TYPE.ADD.getCode());
        //2 更新
        AtpMember atpMember = new AtpMember(atpMemberDTO.getName(),atpMemberDTO.getSex(),atpMemberDTO.getAge(),atpMemberDTO.getPhone(),atpMemberDTO.getAddress(),atpMemberDTO.getRemark(),atpMemberDTO.getCardPwd());
        atpMember.setId(atpMemberDTO.getId());
        atpMember.setLastUpdatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpMember.setLastUpdatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpMember.setLastUpdatedTime(new Date());
        atpMemberDao.updateById(atpMember);
    }

    @Override
    public List<AtpCourseDTO> queryCourseListByMemId(Long memberId) throws ATPException {
        if(Objects.isNull(memberId)){
            return null;
        }
        return atpMemberDao.queryCourseListByMemId(memberId);
    }

    @Override
    public BasePageResponse<AtpCourseDTO> queryAllList(AtpMemberDTO atpMemberDTO) throws ATPException {
        Page<Object> page = PageHelper.startPage(atpMemberDTO.getPage(), atpMemberDTO.getPageSize(), StringUtils.isBlank(atpMemberDTO.getOrderBy()) ? "":atpMemberDTO.getOrderBy());
        List<AtpCourseDTO> list = atpMemberDao.queryAllList(atpMemberDTO);
        BasePageResponse<AtpCourseDTO> response = new BasePageResponse<AtpCourseDTO>();

        if (list != null) {
            response.setRows(list);
            response.setTotal((int) page.getTotal());
            response.setTotalPage(atpMemberDTO.getPageSize());
        }

        return response;
    }
}
