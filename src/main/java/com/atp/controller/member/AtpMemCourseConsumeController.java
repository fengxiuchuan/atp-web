package com.atp.controller.member;


import com.atp.controller.BaseController;
import com.atp.service.member.AtpMemCourseConsumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description: AtpMemCourseConsumecontroller
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:28
 */
@RestController
@RequestMapping("/atpMemCourseConsume")
public class AtpMemCourseConsumeController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AtpMemCourseConsumeService atpMemCourseConsumeService;


    //1 会员 - 课程 课耗统计

    

}
