package com.atp.base;

import com.atp.Application;
import com.atp.entity.base.City;
import com.atp.service.base.CityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/5/29 14 12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class CityTest {

    @Resource
    private CityService cityService;

    @Test
    public void queryAllList(){
        List<City> cityList =  cityService.queryAllList();
        Assert.assertNotNull(cityList);
    }
}
