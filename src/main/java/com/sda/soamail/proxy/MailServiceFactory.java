package com.sda.soamail.proxy;

import com.sda.soamail.service.MailService;
import org.springframework.stereotype.Component;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 集中管理所有 MailService 实现
 * 修复点：不再依赖构造函数注入Map，改用ApplicationContext动态获取
 */
@Component
public class MailServiceFactory {

    private final ApplicationContext context;
    private static final String DEFAULT_PROVIDER = "aliyun";

    @Autowired
    public MailServiceFactory(ApplicationContext context) {
        this.context = context;
    }

    /**
     * 根据名字获取对应服务实现
     * name = "aliyun" -> "aliyunMailService"
     */
    public MailService getActiveService(String name) {
        if (name == null || name.trim().isEmpty()) {
            name = DEFAULT_PROVIDER;
        }

        String beanName = name.toLowerCase() + "MailService";
        try {
            return context.getBean(beanName, MailService.class);
        } catch (Exception e) {
            // 降级到默认服务
            return context.getBean(DEFAULT_PROVIDER + "MailService", MailService.class);
        }
    }
}
