package com.luban.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

//@Component
@Configuration
public class AppConfig   {
    /**
     * 为什么使用@Bean可以注入容器生效 ，而@Component不可以
     *  @return
     */

    @Bean
    public TomcatServletWebServerFactory servletWebServerFactory(){
        TomcatServletWebServerFactory
                tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.setPort(8081);
        return tomcatServletWebServerFactory;
    }
    /**
     * 为Spring容器配置一个线程池
     */

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(6);
        return threadPoolTaskExecutor;
    }

    /**
     * 配置异常处理器
     * @return
     */
    @Bean
    public ErrorHandler errorHandler(){
        ErrorHandler errorHandler = throwable -> {
            try {
                throwable.getCause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        return errorHandler;
    }

    /**
     * 自定义web容器   1
     */
    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer(){
        WebServerFactoryCustomizer webServerFactoryCustomizer = new WebServerFactoryCustomizer() {
            @Override
            public void customize(WebServerFactory factory) {
                //factory 当前正在使用的Web容器factory对象
                TomcatServletWebServerFactory tomcatServletWebServerFactory = (TomcatServletWebServerFactory) factory;
                tomcatServletWebServerFactory.setPort(8081);
            }
        };
        return webServerFactoryCustomizer;
    }

    /**
     * 自定义web容器   2
     *
     *
     *
     * @ConditionalOnMissingBean(value = ServletWebServerFactory.class, search = SearchStrategy.CURRENT) springboot初始化的时候会去判断是否
     * 程序员是否自己注入了ServletWebServerFactory容器，如果没有就按照顺序new，new一个就不会会去new其他的
     * 使用其它web容器，需要把web-start中的tomcat依赖剔除掉，因为项目中存在两个web容器 会报错 （）
     *
     */



    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(){
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.setPort(8082);

        return tomcatServletWebServerFactory;

    }
}
