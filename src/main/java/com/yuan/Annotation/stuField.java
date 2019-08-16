package com.yuan.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author:袁航
 * Date:2019-08-11 22:08
 * Description:<描述>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface stuField {
    String columnName();
    String type();
    int length();
}
