package com.atp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/9/21 11 07
 */
public class LoginTimeOutException extends Exception{
    private static final long serialVersionUID = -1905099836571109475L;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //异常码
    public String code;
    //异常信息
    public String message;

    public LoginTimeOutException() {
        super();
    }

    public LoginTimeOutException(String code,String message, Throwable cause){
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public LoginTimeOutException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
    public LoginTimeOutException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public LoginTimeOutException(Throwable cause) {
        super(cause);
    }

    public LoginTimeOutException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void writeTo(HttpServletResponse resp){

        try {
            resp.setContentType("application/json");
            resp.getWriter().append("{success:false,message:'" + getMessage() +  "'}");
            resp.getWriter().flush();

        } catch (IOException e) {
            logger.error("【在返回错误提示信息时发生异常】",e);
            try {
                resp.getWriter().append("{success:false,message:'业务处理反馈信息发生了异常，详细请查看日志信息!'}");
            } catch (IOException e1) {
                logger.error("【在返回错误提示信息时发生异常】",e);
            }
        }
    }
}
