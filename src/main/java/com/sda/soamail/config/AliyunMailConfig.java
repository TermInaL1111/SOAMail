package com.sda.soamail.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aliyun.mail")
@Getter
@Setter
public class AliyunMailConfig {

    private String accessKeyId;
    private String accessKeySecret;
    private String regionId;
    private String fromAddress;

    // Getter Setter
}