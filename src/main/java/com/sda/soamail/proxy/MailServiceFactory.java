package com.sda.soamail.proxy;

import com.sda.soamail.service.MailService;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 集中管理所有 MailService 实现
 */
@Component
public class MailServiceFactory {

    private final Map<String, MailService> services;

    public MailServiceFactory(Map<String, MailService> services) {
        this.services = services;
    }

    /**
     * 根据名字获取对应服务实现
     * name = "aliyun" -> "aliyunMailService"
     */
    public MailService get(String name) {
        if (name == null) name = "aliyun"; // 默认服务
        return services.get(name + "MailService");
    }
}