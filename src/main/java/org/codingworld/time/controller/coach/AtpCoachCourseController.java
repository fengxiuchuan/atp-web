package org.codingworld.time.controller.coach;


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
import org.codingworld.time.entity.coach.AtpCoachCourse;
import org.codingworld.time.dto.coach.AtpCoachCourseDTO;
import org.codingworld.time.service.coach. AtpCoachCourseService;



import org.springframework.web.bind.annotation.RestController;


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
