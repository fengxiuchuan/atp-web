package com.atp.service.impl.base;

import com.atp.common.GlobalConstants;
import com.atp.dao.base.AtpGymDao;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.base.AtpGymDTO;
import com.atp.dto.base.response.BasePageResponse;
import com.atp.dto.coach.AtpCoachDTO;
import com.atp.entity.base.AtpGym;
import com.atp.exception.ATPException;
import com.atp.service.base.AtpGymService;
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
 * @Description: AtpGymService 实现类
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpGymServiceImpl implements AtpGymService {

    @Autowired
    private AtpGymDao atpGymDao;

    @Override
    @Transactional(readOnly = true)
    public AtpGym getById(Long id) {
        if (id == null) {
            return null;
        }
        return atpGymDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<AtpGym> queryList(AtpGymDTO dto)  {
        if (dto == null) {
            return null;
        }
        return atpGymDao.queryList(dto);
    }
    


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(AtpGym record)  {
        if (record == null) {
            return 0;
        }
        return atpGymDao.save(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveBatch(List<AtpGym> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpGymDao.saveBatch(recordList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateById(AtpGym record)  {
        if (record == null) {
            return 0;
        }
        return atpGymDao.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpGymDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpGymDao.deleteBatchByIds(ids);
    }

    @Override
    public BasePageResponse<AtpGymDTO> queryAllList(AtpGymDTO atpGymDTO) throws ATPException {
        Page<Object> page = PageHelper.startPage(atpGymDTO.getPage(), atpGymDTO.getPageSize(), StringUtils.isBlank(atpGymDTO.getOrderBy()) ? "":atpGymDTO.getOrderBy());
        List<AtpGymDTO> list = atpGymDao.queryAllList(atpGymDTO);
        BasePageResponse<AtpGymDTO> response = new BasePageResponse<AtpGymDTO>();

        if (list != null) {
            response.setRows(list);
            response.setTotal((int) page.getTotal());
            response.setTotalPage(atpGymDTO.getPageSize());
        }

        return response;
    }

    private void validateForm(AtpGymDTO atpGymDTO,String submitFormType)throws ATPException{
        //1 校验场馆名称
        if(StringUtils.isBlank(atpGymDTO.getGymName())){
            throw new ATPException("请填写场馆名称");
        }
        //2 校验场馆负责人
        if(StringUtils.isBlank(atpGymDTO.getManager())){
            throw new ATPException("请填写负责人");
        }
        //3 校验场馆负责人联系方式
        if(StringUtils.isBlank(atpGymDTO.getPhone())){
            throw new ATPException("请填写负责人联系方式");
        }
        Long id = null;
        if(StringUtils.isNotBlank(submitFormType) && Objects.equals(GlobalConstants.SUBMIT_FORM_TYPE.EDIT.getCode(),submitFormType)){
            id = atpGymDTO.getId();
        }
        List<AtpGym> gymList = atpGymDao.queryByGymName(atpGymDTO.getGymName(),id);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addGym(AtpGymDTO atpGymDTO) throws ATPException {
        //1 校验
        validateForm(atpGymDTO,GlobalConstants.SUBMIT_FORM_TYPE.ADD.getCode());
        //2 保存
        atpGymDTO.setCreatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpGymDTO.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpGymDTO.setCreatedTime(new Date());
        atpGymDao.save(atpGymDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateGym(AtpGymDTO atpGymDTO) throws ATPException {
        //1 校验
        validateForm(atpGymDTO,GlobalConstants.SUBMIT_FORM_TYPE.EDIT.getCode());
        //2 更新
        AtpGym atpGym = new AtpGym(atpGymDTO.getGymName(),atpGymDTO.getPhone(),atpGymDTO.getManager(),atpGymDTO.getAddress());
        atpGym.setId(atpGymDTO.getId());
        atpGym.setLastUpdatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpGym.setLastUpdatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpGym.setLastUpdatedTime(new Date());
        atpGymDao.updateById(atpGymDTO);
    }

    @Override
    public List<AtpCourseDTO> queryCourseListByGymId(Long gymId) throws ATPException {
        if(Objects.isNull(gymId)){
            return null;
        }
        return atpGymDao.queryCourseListByGymId(gymId);
    }

    @Override
    public List<AtpCoachDTO> queryCoachListByGymId(Long gymId) throws ATPException {
        if(Objects.isNull(gymId)){
            return null;
        }
        return atpGymDao.queryCoachListByGymId(gymId);
    }

    @Override
    public AtpGymDTO queryDetailById(Long gymId) throws ATPException {
        if(Objects.isNull(gymId)){
            return null;
        }
        //1 查询场馆
        AtpGymDTO atpGymDTO  = atpGymDao.queryDetailById(gymId);
        //2 查询课程
        List<AtpCourseDTO> courseList = atpGymDao.queryCourseListByGymId(gymId);
        //3 查询教练
        List<AtpCoachDTO> coachList = atpGymDao.queryCoachListByGymId(gymId);

        if(CollectionUtils.isNotEmpty(courseList)){
            atpGymDTO.setCourseList(courseList);
        }
        if(CollectionUtils.isNotEmpty(coachList)){
            atpGymDTO.setCoachList(coachList);
        }
        return atpGymDTO;
    }
}
