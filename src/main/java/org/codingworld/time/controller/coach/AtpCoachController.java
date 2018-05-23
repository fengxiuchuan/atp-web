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
import org.codingworld.time.entity.coach.AtpCoach;
import org.codingworld.time.dto.coach.AtpCoachDTO;
import org.codingworld.time.service.coach. AtpCoachService;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: AtpCoachcontroller
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:34:16
 */
@RestController
@RequestMapping("/atpCoach")
public class AtpCoachController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AtpCoachService atpCoachService;



}
