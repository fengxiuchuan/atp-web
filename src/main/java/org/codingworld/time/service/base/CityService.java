package org.codingworld.time.service.base;

import java.util.List;

import org.codingworld.time.dto.base.response.BasePageResponse;
import org.codingworld.time.entity.base.City;
import org.codingworld.time.dto.base.CityDTO;

/**
 * @Description: CityService
 * @author: fengxiuchuan
 * @date: 2018-03-02 11:37:51
 */
public interface CityService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return City 对象信息
     * @author: fengxiuchuan
     * @date: 2018-03-02 11:37:51
     */
    City getById(Long id) ;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto Citydto查询对象
     * @return List<City> City对象列表
     * @author: fengxiuchuan
     * @date: 2018-03-02 11:37:51
     */
    List<City> queryList(CityDTO dto) ;

    /**
     * 保存对象信息
     * 
     * @param  City对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-03-02 11:37:51
     */
    int save(City record);

    /**
     * 批量保存对象信息
     * 
     * @param List City对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-03-02 11:37:51
     */
    int saveBatch(List<City> recordList);

    /**
     * 根据Id修改对象信息
     * 
     * @param  City对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-03-02 11:37:51
     */
    int updateById(City record);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id City对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-03-02 11:37:51
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids City对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-03-02 11:37:51
     */
    int deleteBatchByIds(List<Long> ids);

    List<City> queryAllList();

    BasePageResponse<CityDTO> queryCityList(CityDTO dto);
}
