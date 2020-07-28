package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 不需要加ComponteScan 默认扫描当前类所在类的子目录
 *(exclude = {DataSourceAutoConfiguration.class}) 剔除不需要自动加载的类
 *
 */
@SpringBootApplication
public class App  {


    /**
     * 打成war包  继承  extends SpringBootServletInitializer
     * @param
     * @return

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder).sources(App.class);
    }
     */

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
