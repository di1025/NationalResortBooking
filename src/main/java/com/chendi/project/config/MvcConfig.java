package com.chendi.project.config;

import com.chendi.project.config.viewerresolver.JsonViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.chendi.project.api")
@Import({SwaggerConfig.class})
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public ViewResolver contentNeogotiatingViewResolver(ContentNegotiationManager manager){
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        List<ViewResolver> viewResolversImpl = new ArrayList<>();
        viewResolversImpl.add(new JsonViewResolver());
        resolver.setViewResolvers(viewResolversImpl);
        return resolver;
    }
    @Bean
    public ViewResolver jsonViewResolver(){
        return new JsonViewResolver();
    }

    @Bean
    public DeviceHandlerMethodArgumentResolver deviceHandlerMethodArgumentResolver(){
        return new DeviceHandlerMethodArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
        argumentResolvers.add(deviceHandlerMethodArgumentResolver());
    }


}
