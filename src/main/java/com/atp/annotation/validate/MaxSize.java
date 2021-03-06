package com.atp.annotation.validate;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/10/17 09 28
 */

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxSize {

    public int max() default 20;

    public String message() default "长度太长";
}
