package com.yhj.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

import java.util.Properties;

// pagehelper参数配置类,注意不要重名了
@Configuration
public class PageHelperConfig {

    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();

        //数据库
        properties.setProperty("helperDialect","oracle");
        //是否将参数offset作为PageNum使用
        properties.setProperty("offsetAsPagenum","true");
        //是否进行count查询
        properties.setProperty("rowBoundsWithCount","true");
        //是否分页合理化
        properties.setProperty("reasonable","true");

        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
