package com.atp.controller.base;


import com.atp.controller.BaseController;
import com.atp.service.base.AtpGymProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description: AtpGymProgramcontroller
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:11
 */
@RestController
@RequestMapping("/atpGymProgram")
public class AtpGymProgramController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AtpGymProgramService atpGymProgramService;



}
