package com.atp.base;

import com.atp.Application;
import com.atp.common.GlobalConstants;
import com.atp.dto.base.AtpGymDTO;
import com.atp.entity.base.AtpGym;
import com.atp.exception.ATPException;
import com.atp.service.base.AtpGymService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/5/29 13 43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class AtpGymTest {

    @Resource
    private AtpGymService atpGymService;

    @Test
    public void testAddGym(){
        AtpGym atpGym = new AtpGym();
        atpGym.setGymName("ATP三店");
        atpGym.setManager("小郑");
        atpGym.setPhone("13506350635");
        atpGym.setAddress("聊城市东昌路201号");
        atpGym.setCreatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpGym.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpGym.setCreatedTime(new Date());
        atpGymService.save(atpGym);
    }

    @Test
    public void testUpdateGym(){
        AtpGym atpGym = new AtpGym();
        atpGym.setId(1L);
        atpGym.setGymName("ATP三店-修改");
        atpGym.setManager("小张");
        atpGym.setPhone("18104452323");
        atpGym.setAddress("");
        atpGym.setLastUpdatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpGym.setLastUpdatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpGym.setLastUpdatedTime(new Date());
        atpGymService.updateById(atpGym);
    }

    @Test
    public void queryDetailById()throws ATPException{
        Long gymId = 1L;
        AtpGymDTO atpGymDTO = atpGymService.queryDetailById(gymId);
        Assert.assertNotNull(atpGymDTO);
    }
}
