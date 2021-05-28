package io.renren.ureport.config;



import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 *  Ureport2 配置类
 */

@Configuration
@ImportResource("classpath:ureport-console-context.xml")
public class UReportConfig {
    @Bean
    public ServletRegistrationBean ureportServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new UReportServlet());
        bean.addUrlMappings("/ureport/*");
        return bean;
    }
}



