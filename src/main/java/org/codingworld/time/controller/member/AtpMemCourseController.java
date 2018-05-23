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
import org.codingworld.time.entity.member.AtpMemCourse;
import org.codingworld.time.dto.member.AtpMemCourseDTO;
import org.codingworld.time.service.member. AtpMemCourseService;



import org.springframework.web.bind.annotation.RestController;


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
