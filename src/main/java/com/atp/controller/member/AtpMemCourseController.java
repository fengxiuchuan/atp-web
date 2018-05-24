package com.atp.controller.member;


import com.atp.controller.BaseController;
import com.atp.service.member.AtpMemCourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description: AtpMemCoursecontroller
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:26
 */
@RestController
@RequestMapping("/atpMemCourse")
public class AtpMemCourseController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AtpMemCourseService atpMemCourseService;



}
