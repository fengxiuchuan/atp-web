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

import org.codingworld.time.entity.base.AtpGym;
import org.codingworld.time.dto.base.AtpGymDTO;
import org.codingworld.time.service.base. AtpGymService;



import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: AtpGymcontroller
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:10
 */
@RestController
@RequestMapping("/atpGym")
public class AtpGymController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AtpGymService atpGymService;



}
