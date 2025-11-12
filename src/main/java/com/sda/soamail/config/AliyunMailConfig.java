package com.sda.soamail.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "aliyun.mail")
@Getter
@Setter
@Component
//@RefreshScope // 关键注解！支持配置动态刷新
public class AliyunMailConfig {

    private String accessKeyId;

    private String accessKeySecret;

    private String regionId;

    private String fromAddress;

    // 创建阿里云客户端的方法...
}