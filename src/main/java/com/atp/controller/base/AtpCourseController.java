package com.atp.controller.base;


import com.atp.common.GlobalConstants;
import com.atp.common.ResultMessage;
import com.atp.controller.BaseController;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.exception.ATPException;
import com.atp.service.base.AtpCourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


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


    /**
     *
     * 功能描述: 查询课程列表
     *
     * @param: atpCourseDTO
     * @return: ResultMessage对象
     * @auther: fengxiuchuan
     * @date: 2018/5/24 14:36
     */
    @PostMapping(value = "/queryAllList.json")
    public ResultMessage queryAlllist(AtpCourseDTO atpCourseDTO) throws ATPException {
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",atpCourseService.queryAllList(atpCourseDTO),true);
    }
    /**
     *
     * 功能描述: 新增课程
     *
     * @param:
     * @return:
     * @auther: fengxiuchuan
     * @date: 2018/5/24 14:37
     */
    @PostMapping(value = "/addCourse.do")
    public ResultMessage addCourse(AtpCourseDTO atpCourseDTO) throws ATPException {
        atpCourseService.addCourse(atpCourseDTO);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"添加课程成功");
    }
    /**
     *
     * 功能描述: 修改课程
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/24 14:37
     */
    @PostMapping(value = "/updateCourse.do")
    public ResultMessage updateCourse(AtpCourseDTO atpCourseDTO) throws ATPException {
        atpCourseService.updateCourse(atpCourseDTO);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"修改课程成功");
    }


}
