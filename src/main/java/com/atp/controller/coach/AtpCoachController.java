package com.atp.controller.coach;


import com.atp.common.GlobalConstants;
import com.atp.common.ResultMessage;
import com.atp.controller.BaseController;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.coach.AtpCoachDTO;
import com.atp.exception.ATPException;
import com.atp.service.coach.AtpCoachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


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



    /**
     *
     * 功能描述: 查询列表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/24 15:23
     */
    @PostMapping(value = "/queryAllList.json")
    public ResultMessage queryAllList(AtpCoachDTO atpCoachDTO) throws ATPException {
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",atpCoachService.queryAllList(atpCoachDTO),true);
    }
    /**
     *
     * 功能描述: 新增保存
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/24 15:23
     */
    @PostMapping(value = "/addCoach.do")
    public ResultMessage addCoach(AtpCoachDTO atpCoachDTO) throws ATPException {
        atpCoachService.addCoach(atpCoachDTO);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"保存成功");
    }

    /**
     *
     * 功能描述: 修改
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/24 15:23
     */
    @PostMapping(value = "/updateCoach.do")
    public ResultMessage updateCoach(AtpCoachDTO atpCoachDTO) throws ATPException {
        atpCoachService.updateCoach(atpCoachDTO);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"更新成功");
    }


    /**
     *
     * 功能描述: 查看教练擅长项目
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/24 15:22
     */
    @GetMapping(value = "/queryCourseListByCoachId.json")
    public ResultMessage queryCourseListByCoachId(Long coachId, String token) throws ATPException {
        List<AtpCourseDTO> courseList =  atpCoachService.queryCourseListByCoachId(coachId);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",courseList,true);
    }

    /**
     *
     * 功能描述:根据教练主键查询教练信息
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/24 15:23
     */
    @GetMapping(value = "/queryDetailById.json")
    public ResultMessage queryDetailById(Long coachId, String token) throws ATPException {
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",atpCoachService.queryDetailById(coachId),true);
    }

    /**
     *
     * 功能描述: 根据教练课程主键删除关联课程
     *
     * @param:
     * @return: 
     * @auther: Administrator
     * @date: 2018/6/30 16:38
     */
    @PostMapping(value = "/delCoachCourseById.do")
    public ResultMessage delCoachCourseById(Long coachCourseId,String token) throws ATPException{
        int count = atpCoachService.delCoachCourseById(coachCourseId);
        if(count > 0){
            return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"删除成功");
        }
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_FAIL,"删除失败");
    }
}
