package com.atp.member;

import com.atp.Application;
import com.atp.common.GlobalConstants;
import com.atp.dao.member.AtpMemberDao;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.member.AtpMemberDTO;
import com.atp.entity.member.AtpMember;
import com.atp.exception.ATPException;
import com.atp.service.member.AtpMemberService;
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
 * @Date : 2018/5/29 17 47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class AtpMemberTest {

    @Resource
    private AtpMemberService atpMemberService;

    @Resource
    private AtpMemberDao atpMemberDao;


    @Test
    public void testAdd(){
        AtpMember atpMember = new AtpMember();
        atpMember.setCardNo("A-1805001");
        atpMember.setAge((short)23);
        atpMember.setAddress("测试");
        atpMember.setName("小芬芬");
        atpMember.setPhone("1892828");
        atpMember.setSex(GlobalConstants.SEX.WOMAN.getValue());
        atpMember.setCardPwd("dddd");
        atpMember.setRemark("这是测试用户");
        atpMember.setCreatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpMember.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpMember.setCreatedTime(new Date());
        atpMemberService.save(atpMember);
    }

    @Test
    public void testUpdate(){
        AtpMember atpMember = new AtpMember();
        atpMember.setId(1L);
        atpMember.setCardNo("A-222");
        atpMember.setAge((short)23);
        atpMember.setAddress("测试-修改");
        atpMember.setName("小芬芬-修改");
        atpMember.setPhone("18928280635");
        atpMember.setSex(GlobalConstants.SEX.WOMAN.getValue());
        atpMember.setCardPwd("dljljl");
        atpMember.setRemark("这是测试用户-修改");
        atpMember.setLastUpdatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpMember.setLastUpdatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpMember.setLastUpdatedTime(new Date());
        atpMemberService.updateById(atpMember);
    }

    @Test
    public  void testQueryCourseListByMemId()throws ATPException{
        Long id = 2L;
        List<AtpCourseDTO> atpCourseDTOList = atpMemberService.queryCourseListByMemId(id);
        Assert.assertNotNull("不为空",atpCourseDTOList);
    }

    @Test
    public void testQueryList()throws ATPException{
        AtpMemberDTO atpMemberDTO  = new AtpMemberDTO();
       // atpMemberDTO.setName("aaa");
        List<AtpMemberDTO> list =  atpMemberDao.queryAllList(atpMemberDTO);
        System.out.println(list);
    }
}
