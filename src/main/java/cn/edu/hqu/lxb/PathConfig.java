package cn.edu.hqu.lxb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration  
public class PathConfig implements WebMvcConfigurer{  
  
    @Override  
    public void addResourceHandlers(ResourceHandlerRegistry registry) {  
        
    //	registry.addResourceHandler("\\**").addResourceLocations("\\resources\\pics\\");  
  
    }  
            
}  