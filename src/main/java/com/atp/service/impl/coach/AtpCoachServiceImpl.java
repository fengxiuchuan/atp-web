package com.atp.service.impl.coach;

import com.atp.common.GlobalConstants;
import com.atp.dao.coach.AtpCoachDao;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.base.response.BasePageResponse;
import com.atp.dto.coach.AtpCoachDTO;
import com.atp.entity.coach.AtpCoach;
import com.atp.exception.ATPException;
import com.atp.service.coach.AtpCoachService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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
    public int save(AtpCoach record)  {
        if (record == null) {
            return 0;
        }
        return atpCoachDao.save(record);
    }

    @Override
    public int saveBatch(List<AtpCoach> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpCoachDao.saveBatch(recordList);
    }

    @Override
    public int updateById(AtpCoach record)  {
        if (record == null) {
            return 0;
        }
        return atpCoachDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpCoachDao.deleteByPrimaryKey(id);
    }

    @Override
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
            throw new ATPException("改教练已经存在");
        }
    }

    @Override
    public void addCoach(AtpCoachDTO atpCoachDTO) throws ATPException {
        //1 校验
        validateForm(atpCoachDTO,GlobalConstants.SUBMIT_FORM_TYPE.ADD.getCode());
        //2 保存
        atpCoachDao.save(atpCoachDTO);
    }

    @Override
    public void updateCoach(AtpCoachDTO atpCoachDTO) throws ATPException {
        //1 校验
        validateForm(atpCoachDTO,GlobalConstants.SUBMIT_FORM_TYPE.EDIT.getCode());
        //2 更新
        AtpCoach atpCoach = new AtpCoach(atpCoachDTO.getCoachNo(),atpCoachDTO.getCoachName(),atpCoachDTO.getSex(),atpCoachDTO.getAge(),
                atpCoachDTO.getGymId(),atpCoachDTO.getJobState(),atpCoachDTO.getUserAccount(),atpCoachDTO.getUserPasswd());
        atpCoach.setId(atpCoachDTO.getId());

        atpCoachDao.updateById(atpCoach);

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
}
