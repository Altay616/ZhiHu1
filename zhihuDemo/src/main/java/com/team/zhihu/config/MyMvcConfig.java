package com.team.zhihu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.team.zhihu.component.MyInterceptor;

@Configuration
public class MyMvcConfig  implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		 registry.addViewController("/").setViewName("login");
		 registry.addViewController("/index.html").setViewName("login");
		 registry.addViewController("/user/register").setViewName("register");
		 registry.addViewController("/content").setViewName("content");
		 registry.addViewController("/comment").setViewName("comment");
		 
	}
	
	// 拦截器
	 @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user/*")
                .excludePathPatterns("/")
                .excludePathPatterns("/index.html")
                .excludePathPatterns("/css/*")
                .excludePathPatterns("/images/*");
    }
	
}

