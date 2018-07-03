package com.atp.base;

import com.atp.Application;
import com.atp.entity.base.City;
import com.atp.service.base.CityService;
import net.sf.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testParaseJson(){
        String record = "[{\"nextflownum\":\"5\",\"gtactionurl\":\"\",\"nextstat\":\"职能组负责人和分管领导审核\",\"userid\":\"LMS162\",\"time\":\"2018-07-02 09:51:30\",\"nextstatuserid\":\"LMS138\",\"user\":\"法务测试162\",\"stat\":\"起草\",\"flownum\":\"0\",\"nextstatusers\":\"法务测试138\"},{\"time\":\"2018-07-02 10:16:09\",\"userid\":\"LMS138\",\"flownum\":\"5\",\"nextstatuserid\":\"flgw\",\"nextflownum\":\"2\",\"nextstat\":\"集团法律公文转办\",\"stat\":\"职能组负责人和分管领导审核\",\"gtactionurl\":\"\",\"nextstatusers\":\"法律公文\",\"user\":\"法务测试138\"},{\"userid\":\"flgw\",\"user\":\"法律公文\",\"stat\":\"集团法律公文转办\",\"nextflownum\":\"1002\",\"time\":\"2018-07-02 10:21:33\",\"flownum\":\"2\",\"nextstat\":\"集团法律部初审\",\"nextstatuserid\":\"LMS125\",\"gtactionurl\":\"\",\"nextstatusers\":\"法务测试125\"},{\"userid\":\"LMS125\",\"user\":\"法务测试125\",\"gtactionurl\":\"\",\"nextflownum\":\"1003\",\"nextstat\":\"集团法律部复审\",\"time\":\"2018-07-02 10:22:22\",\"nextstatusers\":\"法务测试126\",\"flownum\":\"1002\",\"stat\":\"集团法律部初审\",\"nextstatuserid\":\"LMS126\"},{\"nextstat\":\"集团法律公文汇总反馈\",\"flownum\":\"1003\",\"gtactionurl\":\"\",\"stat\":\"集团法律部复审\",\"nextstatuserid\":\"flgw\",\"nextflownum\":\"1005\",\"time\":\"2018-07-02 10:23:18\",\"nextstatusers\":\"法律公文\",\"user\":\"法务测试126\",\"userid\":\"LMS126\"},{\"nextflownum\":\"4\",\"nextstat\":\"修改与反馈\",\"flownum\":\"1005\",\"user\":\"法律公文\",\"time\":\"2018-07-02 10:25:16\",\"gtactionurl\":\"\",\"nextstatuserid\":\"LMS162\",\"userid\":\"flgw\",\"stat\":\"集团法律公文汇总反馈\",\"nextstatusers\":\"法务测试162\"},{\"nextstat\":\"职能组负责人和分管领导审核\",\"user\":\"法务测试162\",\"flownum\":\"4\",\"nextstatuserid\":\"LMS138\",\"nextflownum\":\"16\",\"nextstatusers\":\"法务测试138\",\"stat\":\"修改与反馈\",\"time\":\"2018-07-02 10:29:30\",\"userid\":\"LMS162\",\"gtactionurl\":\"\"},{\"nextstatusers\":\"\",\"nextstatuserid\":\"\",\"nextflownum\":\"9999\",\"userid\":\"LMS138\",\"flownum\":\"16\",\"nextstat\":\"流程结束\",\"user\":\"法务测试138\",\"time\":\"2018-07-02 11:13:03\",\"gtactionurl\":\"\",\"stat\":\"职能组负责人和分管领导审核\"}]";
        JSONArray jsonArray = JSONArray.fromObject(record);
        System.out.println(jsonArray.get(0));
    }


}
