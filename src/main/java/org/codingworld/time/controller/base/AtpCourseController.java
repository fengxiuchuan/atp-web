package org.codingworld.time.controller.base;


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

import org.codingworld.time.entity.base.AtpCourse;
import org.codingworld.time.dto.base.AtpCourseDTO;
import org.codingworld.time.service.base. AtpCourseService;



import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: AtpCoursecontroller
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:08
 */
@RestController
@RequestMapping("/atpCourse")
public class AtpCourseController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AtpCourseService atpCourseService;



}
