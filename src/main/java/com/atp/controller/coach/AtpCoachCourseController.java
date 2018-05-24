package com.atp.controller.coach;


import com.atp.controller.BaseController;
import com.atp.service.coach.AtpCoachCourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description: AtpCoachCoursecontroller
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:39:01
 */
@RestController
@RequestMapping("/atpCoachCourse")
public class AtpCoachCourseController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AtpCoachCourseService atpCoachCourseService;




}
