package com.atp.service.impl.base;

import com.atp.common.GlobalConstants;
import com.atp.dao.base.AtpCourseDao;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.base.response.BasePageResponse;
import com.atp.entity.base.AtpCourse;
import com.atp.exception.ATPException;
import com.atp.service.base.AtpCourseService;
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
 * @Description: AtpCourseService 实现类
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:08
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpCourseServiceImpl implements AtpCourseService {

    @Autowired
    private AtpCourseDao atpCourseDao;

    @Override
    @Transactional(readOnly = true)
    public AtpCourse getById(Long id) {
        if (id == null) {
            return null;
        }
        return atpCourseDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<AtpCourse> queryList(AtpCourseDTO dto)  {
        if (dto == null) {
            return null;
        }
        return atpCourseDao.queryList(dto);
    }
    


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(AtpCourse record)  {
        if (record == null) {
            return 0;
        }
        return atpCourseDao.save(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveBatch(List<AtpCourse> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpCourseDao.saveBatch(recordList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateById(AtpCourse record)  {
        if (record == null) {
            return 0;
        }
        return atpCourseDao.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpCourseDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpCourseDao.deleteBatchByIds(ids);
    }

    @Override
    public BasePageResponse<AtpCourseDTO> queryAllList(AtpCourseDTO atpCourseDTO) throws ATPException {
        Page<Object> page = PageHelper.startPage(atpCourseDTO.getPage(), atpCourseDTO.getPageSize(), StringUtils.isBlank(atpCourseDTO.getOrderBy()) ? "":atpCourseDTO.getOrderBy());
        List<AtpCourseDTO> list = atpCourseDao.queryAllList(atpCourseDTO);
        BasePageResponse<AtpCourseDTO> response = new BasePageResponse<AtpCourseDTO>();

        if (list != null) {
            response.setRows(list);
            response.setTotal((int) page.getTotal());
            response.setTotalPage(atpCourseDTO.getPageSize());
        }

        return response;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addCourse(AtpCourseDTO atpCourseDTO) throws ATPException {
        //1 校验
        validateForm(atpCourseDTO, GlobalConstants.SUBMIT_FORM_TYPE.ADD.getCode());
        //2 新增
        atpCourseDTO.setCreatedTime(new Date());
        atpCourseDTO.setCreatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpCourseDTO.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpCourseDao.save(atpCourseDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCourse(AtpCourseDTO atpCourseDTO) throws ATPException {
        //1 校验
        validateForm(atpCourseDTO, GlobalConstants.SUBMIT_FORM_TYPE.EDIT.getCode());
        //2 修改
        AtpCourse atpCourse = new AtpCourse();
        atpCourse.setId(atpCourseDTO.getId());
        atpCourse.setCourseNo(atpCourseDTO.getCourseNo());
        atpCourse.setCourseName(atpCourseDTO.getCourseName());
        atpCourse.setLastUpdatedTime(new Date());
        atpCourseDTO.setLastUpdatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpCourseDTO.setLastUpdatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpCourseDao.updateById(atpCourseDTO);
    }

    //校验
    public void validateForm(AtpCourseDTO atpCourseDTO,String submitFormType) throws ATPException{
        //1 课程编码--自动生成
       /* if(StringUtils.isBlank(atpCourseDTO.getCourseNo())){
            throw new ATPException("请填写课程编码");
        }*/
        //2 课程名称
        if(StringUtils.isBlank(atpCourseDTO.getCourseName())){
            throw new ATPException("请填写课程名称");
        }
        Long id = null;
        //3 唯一性校验
        if(StringUtils.isNotBlank(submitFormType) && Objects.equals(GlobalConstants.SUBMIT_FORM_TYPE.EDIT.getCode(),submitFormType)){
            id = atpCourseDTO.getId();
        }
        List<AtpCourseDTO> courseList =  atpCourseDao.queryByName(atpCourseDTO.getCourseName(),id);
        if(CollectionUtils.isNotEmpty(courseList)){
            throw new ATPException("所添加课程已经存在，请勿重复添加！");
        }
    }

}
