package com.atp.common;

public interface GlobalConstants {

    /**成功**/
    public static final String RESPONSE_CODE_SUCCESS_DEFAULT = "A_SYS_00010";

    /**失败**/
    public static final String RESPONSE_CODE_FAIL = "A_SYS_00011";

    /**
     * 超级管理员
     */
    public static final long SUPER_ADMIN_ID = -1;

    /**
     *  超级管理员用户名
     */
    public static final String SUPER_ADMIN_NAME = "super_admin";

    enum ResultEnum{
        UNKOWN_ERROR("-1","未知错误"),
        SUCCESS("A_SYS_00010","成功");

        String code;

        String msg;
        private ResultEnum(String code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
    /**
     * 功能描述: 表单提交类型
     * @auther: fengxiuchuan
     * @date: 2018/5/24 16:40
     */
    enum SUBMIT_FORM_TYPE{
        ADD("add","新增"),
        EDIT("edit","修改");
        private String code;

        private String desc;

        private SUBMIT_FORM_TYPE(String code,String desc){
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }

    /**
     *
     * 工作状态枚举类
     * @auther: Administrator
     * @date: 2018/5/29 14:37
     */
    enum JOB_STATE{
        Y("Y","在职"),
        N("N","离职");

        private String code;

        private String desc;
        private JOB_STATE(String code,String desc){
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }

    //性别枚举类
    enum SEX{
        MAN((short)0,"男"),
        WOMAN((short)1,"女");

        private Short value;

        private String label;
        private SEX(Short value,String label){
           this.value = value;
           this.label = label;
        }

        public Short getValue() {
            return value;
        }

        public String getLabel() {
            return label;
        }
    }
}
