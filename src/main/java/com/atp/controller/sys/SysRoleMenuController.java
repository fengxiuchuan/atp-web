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
import com.atp.entity.sys.SysRoleMenu;
import com.atp.dto.sys.SysRoleMenuDTO;
import com.atp.service.sys. SysRoleMenuService;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: SysRoleMenucontroller
 * @author: fengxiuchuan
 * @date: 2018-08-09 17:04:19
 */
@RestController
@RequestMapping("/sysRoleMenu")
public class SysRoleMenuController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysRoleMenuService sysRoleMenuService;



}
