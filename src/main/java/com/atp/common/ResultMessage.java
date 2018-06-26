package com.atp.common;


import java.io.Serializable;

public class ResultMessage implements Serializable {

    private static final long serialVersionUID = 1L;


    /** 响应码 */
    protected String code;
    /** 响应消息 */
    protected String msg;
    /** 响应数据 */
    protected Object data;
    /** 反调函数 */
    protected String callFunction;
    /** 反调函数参数 */
    protected String []callParams;
    /** 国际化编码 */
    protected String i18Template;
    /** 国际化编码参数 */
    protected String []i18Params;
    /** 是否为成功状态 */
    protected boolean success;

    public ResultMessage(){}
    /**
     * success
     *
     * @param data
     */
    public ResultMessage(Object data) {
        this(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"登录成功", data,true);
    }

    public ResultMessage(String code, String msg) {
        this(code, msg, null,false);
    }

    public ResultMessage(String code,String msg,boolean success){

        this(code,msg,null,success);
    }

    public ResultMessage(String code, String msg, Object data,boolean success) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = success;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCallFunction() {
        return callFunction;
    }

    public ResultMessage setCallFunction(String callFunction) {
        this.callFunction = callFunction;
        return this;
    }

    public String[] getCallParams() {
        return callParams;
    }

    public ResultMessage setCallParams(String[] callParams) {
        this.callParams = callParams;
        return this;
    }

    public String getI18Template() {
        return i18Template;
    }

    public ResultMessage setI18Template(String i18Template) {
        this.i18Template = i18Template;
        return this;
    }

    public String[] getI18Params() {
        return i18Params;
    }

    public ResultMessage setI18Params(String[] i18Params) {
        this.i18Params = i18Params;

        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


}
