package com.atp.controller.base;


import com.atp.common.GlobalConstants;
import com.atp.common.ResultMessage;
import com.atp.controller.BaseController;
import com.atp.dto.base.CityDTO;
import com.atp.entity.base.City;
import com.atp.service.base.CityService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Description: Citycontroller
 * @author: fengxiuchuan
 * @date: 2018-03-02 11:37:51
 */
@Controller
@RequestMapping("/city")
public class CityController extends BaseController {


    @Resource
    private CityService cityService;


    @ApiOperation(value = "获取城市信息",notes = "根据城市主键Id获取城市信息")
    @ApiImplicitParam(name = "city",value = "城市详细实体city",required = true,dataType="City")
    @ResponseBody
    @RequestMapping(value = "/api/city/{id}",method = RequestMethod.GET)
    public City findCityById(@PathVariable("id") Long id){
        return cityService.getById(id);
    }

    @ApiOperation(value = "获取城市列表",notes = "获取全部城市列表")
    @RequestMapping(value = "/api/city",method = RequestMethod.GET)
    @ResponseBody
    public List<City> findAll(){
        return cityService.queryAllList();
    }

    @ApiOperation(value = "创建城市",notes = "根据City对象创建城市信息")
    @RequestMapping(value = "/api/city",method = RequestMethod.POST)
    @ResponseBody
    public void createCity(@RequestBody City city){
        cityService.save(city);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "城市ID",required = true,dataType = "Long"),
            @ApiImplicitParam(name = "city",value = "城市实体entity",required = true,dataType = "City"),
    })
    @ApiOperation(value = "更新城市",notes = "根据City对象更新城市信息")
    @RequestMapping(value = "/api/city/{id}",method = RequestMethod.PUT)
    public void modifyCity(@PathVariable("id")Long id,@RequestBody City city){
        City newCity = new City();
        newCity.setId(id);
        newCity.setProvinceId(city.getProvinceId());
        newCity.setCityName(city.getCityName());
        newCity.setDescription(city.getDescription());
        cityService.updateById(newCity);
    }

    @ApiOperation(value = "删除城市",notes = "根据主键ID删除城市信息")
    @RequestMapping(value = "/api/city/{id}",method = RequestMethod.DELETE)
    public void deleteCityById(@PathVariable("id") Long id){
        cityService.deleteById(id);
    }

    @ApiOperation(value = "分页查询城市列表",notes = "根据主键ID删除城市信息")
    @RequestMapping(value = "/queryCityList.json",method = RequestMethod.POST)
    @ResponseBody
    public ResultMessage queryCityList(CityDTO dto){
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",cityService.queryCityList(dto),true);
    }

    @GetMapping("/citylist")
    public String cityLIst(){
      return "citylist";
    }
}
