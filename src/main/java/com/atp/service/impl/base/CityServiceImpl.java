package com.atp.service.impl.base;

import com.atp.dao.base.CityDao;
import com.atp.dto.base.CityDTO;
import com.atp.dto.base.response.BasePageResponse;
import com.atp.entity.base.City;
import com.atp.service.base.CityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: CityService 实现类
 * @author: fengxiuchuan
 * @date: 2018-03-02 11:37:51
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    @Transactional(readOnly = true)
    public City getById(Long id) {
        if (id == null) {
            return null;
        }
        return cityDao.getById(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<City> queryList(CityDTO dto)  {
        if (dto == null) {
            return null;
        }
        return cityDao.queryList(dto);
    }
    


    @Override
    public int save(City record)  {
        if (record == null) {
            return 0;
        }
        return cityDao.save(record);
    }

    @Override
    public int saveBatch(List<City> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return cityDao.saveBatch(recordList);
    }

    @Override
    public int updateById(City record)  {
        if (record == null) {
            return 0;
        }
        return cityDao.updateById(record);
    }

    @Override
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return cityDao.deleteById(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return cityDao.deleteBatchByIds(ids);
    }

    @Override
    public List<City> queryAllList() {
        return cityDao.queryAllList();
    }

    @Override
    public BasePageResponse<CityDTO> queryCityList(CityDTO cityDTO) {
        Page<Object> page = PageHelper.startPage(cityDTO.getPage(), cityDTO.getPageSize(), StringUtils.isBlank(cityDTO.getOrderBy()) ? "":cityDTO.getOrderBy());
        List<CityDTO> list = cityDao.queryCityList(cityDTO);
        BasePageResponse<CityDTO> response = new BasePageResponse<CityDTO>();

        if (list != null) {
            //设置每条记录的单位
            response.setRows(list);
            response.setTotal((int) page.getTotal());
            response.setTotalPage(cityDTO.getPageSize());//计算总页数
        }

        return response;
    }
}
