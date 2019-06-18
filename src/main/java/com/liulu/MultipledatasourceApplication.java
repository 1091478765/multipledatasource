package com.liulu.multipledatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = "com.liulu.multipledatasource.dao")
//扫描注解所在包以及其他模块基础类
@ComponentScan(basePackages = {"com.liulu.multipledatasource.*", "com.liulu.multipledatasource.config"})
public class MultipledatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipledatasourceApplication.class, args);
    }

}
