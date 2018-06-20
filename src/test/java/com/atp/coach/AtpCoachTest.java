package com.atp.coach;

import com.atp.Application;
import com.atp.common.GlobalConstants;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.coach.AtpCoachDTO;
import com.atp.entity.coach.AtpCoach;
import com.atp.exception.ATPException;
import com.atp.service.coach.AtpCoachService;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/5/29 14 17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class AtpCoachTest {

    @Resource
    private AtpCoachService atpCoachService;

    @Test
    public void testAddCoach(){
        AtpCoach atpCoach = new AtpCoach();
        atpCoach.setCoachName("小辉");
        atpCoach.setCoachNo("C002");
        atpCoach.setAge((short)27);
        atpCoach.setJobState(GlobalConstants.JOB_STATE.Y.getCode());
        atpCoach.setSex(GlobalConstants.SEX.WOMAN.getValue());
        atpCoach.setGymId(1L);
        atpCoach.setUserAccount("xiaohui");
        atpCoach.setUserPasswd("123456");
        atpCoach.setCreatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpCoach.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpCoach.setCreatedTime(new Date());
        atpCoachService.save(atpCoach);
    }

    @Test
    public void testUpdateCoach(){
        AtpCoach atpCoach = new AtpCoach();
        atpCoach.setId(1L);
        atpCoach.setCoachName("小辉-修改");
        atpCoach.setCoachNo("C002-02");
        atpCoach.setAge((short)34);
        atpCoach.setJobState(GlobalConstants.JOB_STATE.Y.getCode());
        atpCoach.setSex(GlobalConstants.SEX.WOMAN.getValue());
        atpCoach.setGymId(23L);
        atpCoach.setUserAccount("xiaohuidd");
        atpCoach.setUserPasswd("7654321");
        atpCoach.setLastUpdatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpCoach.setLastUpdatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpCoach.setLastUpdatedTime(new Date());
        atpCoachService.updateById(atpCoach);
    }

    @Test
    public void testQueryCourseListByCoachId()throws ATPException{
        Long coachId = 1L;
        List<AtpCourseDTO> atpCourseList = atpCoachService.queryCourseListByCoachId(coachId);
        Assert.assertNotNull(atpCourseList);
    }

    @Test
    public void testQueryDetailId()throws ATPException{
        Long coachId = 3L;
        AtpCoachDTO atpCoachDTO = atpCoachService.queryDetailById(coachId);
        Assert.assertNotNull(atpCoachDTO);
    }

    @Test
    public void testNubmer() throws ATPException{
        System.out.println(checkNumber("23%"));
        System.out.println(checkNumber(""));
        System.out.println(checkNumber(" "));
        System.out.println(checkNumber(null));
        System.out.println(checkNumber("333f"));
        System.out.println(checkNumber("-23.3"));
        System.out.println(checkNumber("33"));
        System.out.println(checkNumber("0.1"));
        System.out.println(checkNumber("1.1"));
    }

    /**
     * 校验字符串是否是数值(包含小数与负数)
     * 示例：
     * false : . 1. 1sr -  12. -12.
     * true: -12 -12.0 -12.056 12 12.0 12.056
     *
     * @param str 需要校验的字符串
     * @return false :不是数值 true：是数值
     */
    public static Boolean checkNumber(String str) {
        String regex = "-[0-9]+(.[0-9]+)?|[0-9]+(.[0-9]+)?";
        if (str == null || !str.matches(regex)) {
            return false;
        }
        return true;
    }
}
