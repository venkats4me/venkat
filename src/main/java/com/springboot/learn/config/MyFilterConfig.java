package com.springboot.learn.config;

import com.springboot.learn.filter.CutomerFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean<CutomerFilter> registrationBean() {
        FilterRegistrationBean<CutomerFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CutomerFilter());
        registrationBean.addUrlPatterns("/customers/*");
        return registrationBean;
    }
}