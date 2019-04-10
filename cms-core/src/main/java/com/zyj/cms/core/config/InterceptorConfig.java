package com.zyj.cms.core.config;

import com.zyj.cms.core.common.response.ResponseResultInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhouyajun
 * @date 2019/4/10
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private ResponseResultInterceptor responseResultInterceptor;

    /**
     * 注册拦截器
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
//        String apiUri = "/**";
        registry.addInterceptor(responseResultInterceptor);
    }
}
