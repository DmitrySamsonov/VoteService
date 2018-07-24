//package com.ots.voteservice.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.JstlView;
//import org.springframework.web.servlet.view.UrlBasedViewResolver;
//
//@Configuration
//@EnableWebMvc
//public class WebConfiguration extends WebMvcConfigurerAdapter {
//    @Autowired
//    @Qualifier("jstlViewResolver")
//    private ViewResolver jstlViewResolver;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//
//    }
//
//    @Bean
//    @DependsOn({ "jstlViewResolver" })
//    public ViewResolver viewResolver() {
//        return jstlViewResolver;
//    }
//
//    @Bean(name = "jstlViewResolver")
//    public ViewResolver jstlViewResolver() {
//        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//        resolver.setPrefix(""); // NOTE: no preffix here
//        resolver.setViewClass(JstlView.class);
//        resolver.setSuffix(""); // NOTE: no suffix here
//        return resolver;
//    }
//
//
//}
