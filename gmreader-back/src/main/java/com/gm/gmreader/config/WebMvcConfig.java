package com.gm.gmreader.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import com.gm.gmreader.Filter.AccesslogInterceptor;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private  AccesslogInterceptor accesslogInterceptor;

    @Autowired
    public WebMvcConfig(AccesslogInterceptor accessLogInterceptor) {
        this.accesslogInterceptor = accessLogInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(accesslogInterceptor).addPathPatterns("/**");
    }


//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(accesslogInterceptor).addPathPatterns("/**");
//    }
//

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .exposedHeaders(
                        "token",
                        "ws-token",
                        "access-control-allow-headers",
                        "access-control-allow-methods",
                        "access-control-allow-origin",
                        "access-control-max-age",
                        "X-Frame-Options")
                .allowCredentials(true);
    }
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //配置静态资源处理
            registry.addResourceHandler("/static/**")
                    .addResourceLocations("resources/", "static/", "public/",
                            "META-INF/resources/")
                    .addResourceLocations("classpath:resources/", "classpath:static/",
                            "classpath:public/", "classpath:META-INF/resources/")
                    .addResourceLocations("file:///F:/gmreaderproject/gmreader-back/temp/");
        }


}
