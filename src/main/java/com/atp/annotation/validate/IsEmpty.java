package com.atp.annotation.validate;

import java.lang.annotation.*;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/10/17 09 26
 */
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsEmpty {

    public boolean isEmpty() default  true;

    public String message() default "不能为空";
}
