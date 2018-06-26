package com.atp.util;

import com.atp.common.GlobalConstants;
import com.atp.common.ResultMessage;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/6/26 12 54
 */
public class ResultUtil {

    public static ResultMessage success(){
        return success(null);
    }
    public static ResultMessage success(Object object){
        ResultMessage result = new ResultMessage();
        result.setCode(GlobalConstants.ResultEnum.SUCCESS.getCode());
        result.setMsg(GlobalConstants.ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static ResultMessage error(String  code,String msg){
        ResultMessage result = new ResultMessage();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
