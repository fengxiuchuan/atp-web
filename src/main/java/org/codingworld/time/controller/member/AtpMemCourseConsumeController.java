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
import org.codingworld.time.entity.member.AtpMemCourseConsume;
import org.codingworld.time.dto.member.AtpMemCourseConsumeDTO;
import org.codingworld.time.service.member. AtpMemCourseConsumeService;



import org.springframework.web.bind.annotation.RestController;


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



}
