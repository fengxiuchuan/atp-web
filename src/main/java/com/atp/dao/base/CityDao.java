package com.atp.dao.base;

import com.atp.util.MyMapper;
import com.atp.dto.base.CityDTO;
import com.atp.entity.base.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: CityDao
 * @author: fengxiuchuan
 * @date: 2018-03-02 11:37:51
 */
@Repository
public interface CityDao extends MyMapper<City> {




    /**
     * 根据条件查询对象列表
     * 
     * @param dto Citydto查询对象
     * @return List<City> City对象列表
     * @author: fengxiuchuan
     * @date: 2018-03-02 11:37:51
     */
    List<City> queryList(CityDTO dto);
    

    /**
     * 保存对象信息
     * 
     * @param  City对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-03-02 11:37:51
     */
    int save(City record) ;

    /**
     * 批量保存对象信息
     * 
     * @param List City对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-03-02 11:37:51
     */
    int saveBatch(List<City> recordList) ;


    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids City对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-03-02 11:37:51
     */
    int deleteBatchByIds(List<Long> ids) ;

    /**
     * 根据Id修改对象信息
     *
     * @param record CityVO对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-03-02 11:37:51
     */
    int updateById(City record);

    City getById(Long id);

    int deleteById(Long id);

    List<City> queryAllList();

    List<CityDTO> queryCityList(CityDTO cityDTO);
}
