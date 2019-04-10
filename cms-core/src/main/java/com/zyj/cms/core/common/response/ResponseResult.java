package com.zyj.cms.core.common.response;

import java.lang.annotation.*;

/**
 * @author zhouyajun
 * @date 2019/4/10
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseResult {
    Class<? extends Response> value() default PlatformResponse.class;
}
