package com.atp.controller.sys;


import javax.annotation.Resource;
import java.util.List;

import com.atp.controller.BaseController;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atp.entity.sys.SysMenu;
import com.atp.dto.sys.SysMenuDTO;
import com.atp.service.sys. SysMenuService;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: SysMenucontroller
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:45
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysMenuService sysMenuService;



}