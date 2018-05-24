package com.atp.controller.base;


import com.atp.common.GlobalConstants;
import com.atp.common.ResultMessage;
import com.atp.controller.BaseController;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.base.AtpGymDTO;
import com.atp.dto.coach.AtpCoachDTO;
import com.atp.exception.ATPException;
import com.atp.service.base.AtpGymService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


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


    /**
     *
     * 功能描述: 查询场馆列表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/24 15:06
     */
    @PostMapping(value = "/queryAllList.json")
    public ResultMessage queryAllList(AtpGymDTO atpGymDTO) throws ATPException {
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询列表成功",atpGymService.queryAllList(atpGymDTO),true);
    }
    /**
     *
     * 功能描述: 新增场馆
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/24 15:06
     */
    @PostMapping(value = "/addGym.do")
    public ResultMessage addGym(AtpGymDTO atpGymDTO) throws ATPException {
        atpGymService.addGym(atpGymDTO);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"添加场馆成功");
    }


    /**
     *
     * 功能描述: 修改场馆
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/24 15:07
     */
    @PostMapping(value = "/updateGym.do")
    public ResultMessage updateGym(AtpGymDTO atpGymDTO) throws ATPException {
        atpGymService.updateGym(atpGymDTO);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"修改场馆信息成功");
    }

    /**
     *
     * 功能描述: 查询所有场馆经营课程
     * @param gymId
     *              场馆主键
     * @param token
     *              token
     * @return:
     * @auther: Administrator
     * @date: 2018/5/24 15:07
     */
    @PostMapping(value = "/queryCourseListByGymId.json")
    public ResultMessage queryCourseListByGymId(Long gymId, String token) throws ATPException {
        List<AtpCourseDTO> courseList = atpGymService.queryCourseListByGymId(gymId);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询经营课程成功",courseList,true);
    }

    /**
     *
     * 功能描述: 查询场馆所有教练
     *
     * @param gymId
     *              场馆主键
     * @param token
     *              token
     * @return:
     * @auther: Administrator
     * @date: 2018/5/24 15:12
     */
    @PostMapping(value = "/queryCoachListByGymId.json")
    public ResultMessage queryCoachListByGymId(Long gymId, String token) throws ATPException {
        List<AtpCoachDTO> coachList = atpGymService.queryCoachListByGymId(gymId);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询场馆教练成功",coachList,true);
    }

    /**
     *
     * 功能描述: 根据场馆主键查询场馆详细信息
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/24 15:27
     */
    @PostMapping(value = "/queryDetailById.json")
    public ResultMessage queryDetailById(Long gymId, String token) throws ATPException {
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询场馆教练成功",atpGymService.queryDetailById(gymId),true);
    }

}
