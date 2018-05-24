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
}
