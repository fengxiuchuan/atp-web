package org.codingworld.time.controller.member;


import javax.annotation.Resource;
import java.util.List;

import org.codingworld.time.controller.BaseController;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.codingworld.time.entity.member.AtpMember;
import org.codingworld.time.dto.member.AtpMemberDTO;
import org.codingworld.time.service.member. AtpMemberService;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: AtpMembercontroller
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:29
 */
@RestController
@RequestMapping("/atpMember")
public class AtpMemberController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AtpMemberService atpMemberService;



}
