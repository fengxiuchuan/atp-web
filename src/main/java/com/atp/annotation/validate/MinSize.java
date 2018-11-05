package com.atp.annotation.validate;

import java.lang.annotation.*;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/10/17 09 30
 */
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MinSize {
    public int min() default 0;

    public String message() default "长度太短";
}
