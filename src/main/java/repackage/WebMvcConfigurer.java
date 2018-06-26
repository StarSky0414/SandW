package repackage;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//mvc控制器
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    //增加拦截器
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MyJson())    //指定拦截器类
                .addPathPatterns("/**");        //指定该类拦截的url
    }
}