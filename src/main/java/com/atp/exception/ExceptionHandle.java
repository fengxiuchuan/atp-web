package com.atp.exception;

import com.atp.common.GlobalConstants;
import com.atp.common.ResultMessage;
import com.atp.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/6/26 12 52
 */
@ControllerAdvice
public class ExceptionHandle {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultMessage handler(Exception e){
        if( e instanceof ATPException){
            ATPException studentException = (ATPException) e;
            return ResultUtil.error( studentException.getCode(), studentException.getMessage());
        }else {
            logger.info("[系统异常] {}",e);
            return ResultUtil.error(GlobalConstants.ResultEnum.UNKOWN_ERROR.getCode(), GlobalConstants.ResultEnum.UNKOWN_ERROR.getMsg());
        }
    }

    @ExceptionHandler(value = LoginTimeOutException.class)
    @ResponseBody
    public ResultMessage handlerLoginTimeOut(Exception e){
        if( e instanceof LoginTimeOutException){
            LoginTimeOutException studentException = (LoginTimeOutException) e;
            return ResultUtil.error( studentException.getCode(), studentException.getMessage());
        }else {
            logger.info("[系统异常] {}",e);
            return ResultUtil.error(GlobalConstants.ResultEnum.UNKOWN_ERROR.getCode(), GlobalConstants.ResultEnum.UNKOWN_ERROR.getMsg());
        }
    }
}
