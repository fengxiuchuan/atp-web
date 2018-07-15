package com.atp.service.impl.coach;

import com.atp.common.GlobalConstants;
import com.atp.dao.coach.AtpCoachCourseDao;
import com.atp.dao.coach.AtpCoachDao;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.base.response.BasePageResponse;
import com.atp.dto.coach.AtpCoachDTO;
import com.atp.entity.base.AtpCourse;
import com.atp.entity.coach.AtpCoach;
import com.atp.entity.coach.AtpCoachCourse;
import com.atp.exception.ATPException;
import com.atp.service.base.AtpCourseService;
import com.atp.service.coach.AtpCoachService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: AtpCoachService 实现类
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:34:16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpCoachServiceImpl implements AtpCoachService {

    @Autowired
    private AtpCoachDao atpCoachDao;

    @Autowired
    private AtpCoachCourseDao atpCoachCourseDao;

    @Autowired
    private AtpCourseService atpCourseService;

    @Override
    @Transactional(readOnly = true)
    public AtpCoach getById(Long id) {
        if (id == null) {
            return null;
        }
        return atpCoachDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<AtpCoach> queryList(AtpCoachDTO dto)  {
        if (dto == null) {
            return null;
        }
        return atpCoachDao.queryList(dto);
    }
    


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(AtpCoach record)  {
        if (record == null) {
            return 0;
        }
        return atpCoachDao.save(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveBatch(List<AtpCoach> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpCoachDao.saveBatch(recordList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateById(AtpCoach record)  {
        if (record == null) {
            return 0;
        }
        return atpCoachDao.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpCoachDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpCoachDao.deleteBatchByIds(ids);
    }

    @Override
    public BasePageResponse<AtpCoachDTO> queryAllList(AtpCoachDTO atpCoachDTO) throws ATPException {
        Page<Object> page = PageHelper.startPage(atpCoachDTO.getPage(), atpCoachDTO.getPageSize(), StringUtils.isBlank(atpCoachDTO.getOrderBy()) ? "":atpCoachDTO.getOrderBy());
        List<AtpCoachDTO> list = atpCoachDao.queryAllList(atpCoachDTO);
        BasePageResponse<AtpCoachDTO> response = new BasePageResponse<AtpCoachDTO>();

        if (list != null) {
            response.setRows(list);
            response.setTotal((int) page.getTotal());
            response.setTotalPage(atpCoachDTO.getPageSize());
        }

        return response;
    }


    private void validateForm(AtpCoachDTO atpCoachDTO,String submitFormType) throws ATPException{
        //1 教练编号
        if(StringUtils.isBlank(atpCoachDTO.getCoachNo())){
            throw new ATPException("请填写教练编号");
        }
        //2 教练名称
        if(StringUtils.isBlank(atpCoachDTO.getCoachName())){
            throw new ATPException("请填写教练名称");
        }
        //3 性别
        if(Objects.isNull(atpCoachDTO.getSex())){
            throw new ATPException("请选择性别");
        }
        //4 年龄
        if(Objects.isNull(atpCoachDTO.getAge())){
            throw new ATPException("请填写年龄");
        }
        //5 健身场馆
        if(Objects.isNull(atpCoachDTO.getGymId())){
            throw new ATPException("请选择场馆");
        }
        //6 是否在职
        if(StringUtils.isBlank(atpCoachDTO.getJobState())){
            throw new ATPException("请选择在职状态");
        }
        //7 唯一性校验
        Long id = null;
        if(StringUtils.isNotBlank(submitFormType) && Objects.equals(GlobalConstants.SUBMIT_FORM_TYPE.EDIT.getCode(),submitFormType)){
            id = atpCoachDTO.getId();
        }
        List<AtpCoachDTO> coachList = atpCoachDao.queryByNoOrName(atpCoachDTO.getCoachNo(),atpCoachDTO.getCoachName(),id);
        if(CollectionUtils.isNotEmpty(coachList)){
            throw new ATPException("请勿重复添加教练");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addCoach(AtpCoachDTO atpCoachDTO) throws ATPException {
        //1 校验
        validateForm(atpCoachDTO,GlobalConstants.SUBMIT_FORM_TYPE.ADD.getCode());
        //2 保存
        atpCoachDao.save(atpCoachDTO);
        //3 解析出来课程,保存
        List<AtpCoachCourse> coachCourseList = parseCoachCourse(atpCoachDTO);
        if(CollectionUtils.isNotEmpty(coachCourseList)){
            atpCoachCourseDao.saveBatch(coachCourseList);
        }
    }

    private List<AtpCoachCourse> parseCoachCourse(AtpCoachDTO atpCoachDTO) throws ATPException{
        if(Objects.isNull(atpCoachDTO) || ArrayUtils.isEmpty(atpCoachDTO.getCourseIdArr())){
            return null;
        }
        Long coachId = atpCoachDTO.getId();
        Long [] courseIdArr = atpCoachDTO.getCourseIdArr();
        List<AtpCourse> courseList = atpCourseService.queryList(new AtpCourseDTO());
        if(CollectionUtils.isEmpty(courseList)){
            throw new ATPException("课程列表为空");
        }
        List<AtpCoachCourse> atpCoachCourses = new ArrayList<AtpCoachCourse>();
        for (int i = 0; i < courseIdArr.length; i++) {
            Long courseId = courseIdArr[i];
            if(Objects.isNull(courseId)){
                continue;
            }
            List<AtpCourse> tempCourseList =  courseList.stream().filter(atpCourse ->
                !Objects.isNull(atpCourse) && Objects.equals(atpCourse.getId(),courseId)
            ).collect(Collectors.toList());
            atpCoachCourses.add(new AtpCoachCourse(coachId,courseId,CollectionUtils.isEmpty(tempCourseList) ? "" : tempCourseList.get(0).getCourseName()));
        }
        return atpCoachCourses;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCoach(AtpCoachDTO atpCoachDTO) throws ATPException {
        Long coachId = atpCoachDTO.getId();
        //1 校验
        validateForm(atpCoachDTO,GlobalConstants.SUBMIT_FORM_TYPE.EDIT.getCode());
        //2 更新
        AtpCoach atpCoach = new AtpCoach(atpCoachDTO.getCoachNo(),atpCoachDTO.getCoachName(),atpCoachDTO.getSex(),atpCoachDTO.getAge(),
                atpCoachDTO.getGymId(),atpCoachDTO.getJobState(),atpCoachDTO.getUserAccount(),atpCoachDTO.getUserPasswd());
        atpCoach.setId(coachId);


        atpCoachDao.updateById(atpCoach);
        atpCoachCourseDao.deleteByCoachId(coachId);
        //3 解析出来课程,保存
        List<AtpCoachCourse> coachCourseList = parseCoachCourse(atpCoachDTO);
        if(CollectionUtils.isNotEmpty(coachCourseList)){
            atpCoachCourseDao.saveBatch(coachCourseList);
        }
    }

    @Override
    public List<AtpCourseDTO> queryCourseListByCoachId(Long coachId) throws ATPException {
        if(Objects.isNull(coachId)){
            return null;
        }
        return atpCoachDao.queryCourseListByCoachId(coachId);
    }

    @Override
    public AtpCoachDTO queryDetailById(Long coachId) throws ATPException {
        if(Objects.isNull(coachId)){
            return null;
        }
        return atpCoachDao.queryDetailById(coachId);
    }

    @Override
    public int delCoachCourseById(Long coachCourseId) throws ATPException {
        if(Objects.isNull(coachCourseId)){
            return 0;
        }
        return atpCoachCourseDao.deleteByPrimaryKey(coachCourseId);
    }

    @Override
    public List<AtpCourseDTO> getCoachList() throws ATPException {
        return atpCoachCourseDao.getCoachList();
    }

    @Override
    public List<AtpCoachDTO> queryCoachListByCourseId(Long courseId) throws ATPException {
        if(Objects.isNull(courseId)){
            return null;
        }
        return atpCoachDao.queryCoachListByCourseId(courseId);
    }
}
