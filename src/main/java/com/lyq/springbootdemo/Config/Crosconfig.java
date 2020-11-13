package com.lyq.springbootdemo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//解决跨域访问问题
@Configuration
public class Crosconfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping( "/**" )
                .allowedOrigins( "*" )
                .allowedMethods( "GET","HEAD","POST","PUT","DELETE","OPTIONS")
                .allowCredentials( true )
                .maxAge( 3600 )
                .allowedHeaders( "*" );
    }
}
