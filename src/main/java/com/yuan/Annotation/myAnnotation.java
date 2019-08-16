package com.yuan.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author:袁航
 * Date:2019-08-11 16:36
 * Description:<描述>
 */
@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface myAnnotation {
    String student() default "";//以下均为属性而非方法
    int age() default 0;
    int id();
    String [] schools() default "";

}
