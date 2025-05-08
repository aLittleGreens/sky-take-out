package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AutoFill {
    OperationType value();
}
