package com.atp.base;

import com.atp.Application;
import com.atp.common.GlobalConstants;
import com.atp.common.SerialNoGenerator;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.base.response.BasePageResponse;
import com.atp.entity.base.AtpCourse;
import com.atp.service.base.AtpCourseService;
import com.atp.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/5/29 10 36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class AtpCourseTest {

    @Autowired
    private AtpCourseService atpCourseService;

    @Test
    public void testQueryAllList()throws Exception{
        AtpCourseDTO atpCourseDTO = new AtpCourseDTO();
        atpCourseDTO.setPage(1);
        atpCourseDTO.setPageSize(10);
        BasePageResponse<AtpCourseDTO> response =  atpCourseService.queryAllList(atpCourseDTO);
        Assert.assertNotNull(response);
    }

    /**
     *
     * 功能描述: 测试保存
     *
     * @auther: Administrator
     * @date: 2018/5/29 10:43
     */
    @Test
    public void testAddCourse(){
        AtpCourse atpCourse = new AtpCourse();
        atpCourse.setCourseName("拳击");
        atpCourse.setCourseNo("");
        atpCourse.setCreatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpCourse.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpCourseService.save(atpCourse);
    }

    /**
     *
     * 功能描述: 测试更新
     *
     * @auther: Administrator
     * @date: 2018/5/29 10:46
     */
    @Test
    public void testUpdateCourse(){
        AtpCourse atpCourse = new AtpCourse();
        atpCourse.setId(1L);
        atpCourse.setCourseName("");
        atpCourse.setCourseNo("");
        atpCourse.setRemark("这是修改");
        atpCourse.setLastUpdatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpCourse.setLastUpdatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpCourse.setLastUpdatedTime(new Date());
        atpCourseService.updateById(atpCourse);
    }

    @Test
    public void testGenerrator()throws Exception{
        long serialNo =  SerialNoGenerator.getGenerator().generateSerialNo("riskDataCode" , SerialNoGenerator.Cycle.MONTHLY); // 日循环
        String riskDataCode = String.format("%s%s%s", "LR", SerialNoGenerator.Cycle.getCycleKey(SerialNoGenerator.Cycle.MONTHLY) , StringUtil.padLeft(String.valueOf(serialNo), 6, '0'));
        System.out.println(riskDataCode);
    }
}
