package com.atp.controller.member;


import com.atp.common.GlobalConstants;
import com.atp.common.ResultMessage;
import com.atp.controller.BaseController;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.member.AtpMemCourseConsumeDTO;
import com.atp.dto.member.AtpMemCourseDTO;
import com.atp.dto.member.AtpMemberDTO;
import com.atp.entity.member.AtpMember;
import com.atp.exception.ATPException;
import com.atp.service.impl.member.AtpMemCourseServiceImpl;
import com.atp.service.member.AtpMemCourseConsumeService;
import com.atp.service.member.AtpMemCourseService;
import com.atp.service.member.AtpMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Description: AtpMembercontroller
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:29
 */
@RestController
@RequestMapping("/atpMember")
@CrossOrigin
public class AtpMemberController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AtpMemberService atpMemberService;

    @Resource
    private AtpMemCourseService atpMemCourseService;

    @Resource
    private AtpMemCourseConsumeService atpMemCourseConsumeService;

    //1 会员列表
    @PostMapping(value = "/queryAllList.json")
    public ResultMessage queryAllList(AtpMemberDTO atpMemberDTO) throws ATPException {
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",atpMemberService.queryAllList(atpMemberDTO),true);
    }
    //2 新增会员
    @PostMapping(value = "/addMem.do")
    public ResultMessage addMem(AtpMemberDTO atpMemberDTO) throws ATPException {
        atpMemberService.addMem(atpMemberDTO);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"保存成功");
    }

    //3 修改会员信息
    @PostMapping(value = "/updateMem.do")
    public ResultMessage updateMem(AtpMemberDTO atpMemberDTO) throws ATPException {
        atpMemberService.updateMem(atpMemberDTO);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"修改成功");
    }

    //4 会员充值
    @PostMapping(value = "/payCourse.do")
    public ResultMessage payCourse(AtpMemCourseDTO atpMemCourseDTO) throws ATPException {
        atpMemCourseService.payCourse(atpMemCourseDTO);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"充值成功");
    }

    //5 会员销课
    @PostMapping(value = "/consumeCourse.do")
    public ResultMessage consumeCourse(AtpMemCourseConsumeDTO consumeDTO) throws ATPException{
        logger.info("AtpMemberController  --  consumeCourse start");
        atpMemCourseService.consumeCourse(consumeDTO);
        logger.info("AtpMemberController  --  consumeCourse end");
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"成功销课");
    }

    //6 查询会员所报课程
    @GetMapping(value = "/queryCourseListByMemId.json")
    public ResultMessage queryCourseListByMemId(Long memberId,String token) throws ATPException{
        List<AtpMemCourseDTO> courseList = atpMemberService.queryCourseListByMemId(memberId);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",courseList,true);
    }

    //7 根据主键查询会员详情
    @GetMapping(value = "/getMemById.json")
    public ResultMessage getMemById(Long memberId,String token) throws ATPException{
        AtpMember atpMember = atpMemberService.getById(memberId);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",atpMember,true);
    }

    @PostMapping(value = "/getMemberList.json")
    public ResultMessage getMemberList(String token) throws ATPException{
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",atpMemberService.getMemberList(),true);
    }

    // 充值列表
    @PostMapping(value = "/queryMemCourseList.json")
    public ResultMessage queryMemCourseList(AtpMemCourseDTO memCourseDTO) throws ATPException {
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",atpMemberService.queryMemCourseList(memCourseDTO),true);
    }


    // 充值列表
    @PostMapping(value = "/queryConsumeList.json")
    public ResultMessage queryConsumeList(AtpMemCourseConsumeDTO consumeDTO) throws ATPException {
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",atpMemberService.queryConsumeList(consumeDTO),true);
    }

    @PostMapping(value = "/testJson.do")
    public void testJson(String json) throws ATPException {
       logger.info("--------------开始提交---------------");
       logger.info("json");
       logger.info("--------------开始提交---------------");
    }
}