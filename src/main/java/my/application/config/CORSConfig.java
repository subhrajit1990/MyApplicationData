package my.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;




@SuppressWarnings("deprecation")
@Configuration
public class CORSConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new AccessControlInterceptor ()).addPathPatterns("/**");
    }
}