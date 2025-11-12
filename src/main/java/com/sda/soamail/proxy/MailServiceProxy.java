package com.sda.soamail.proxy;

import com.sda.soamail.service.MailService;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 对外统一调用邮件服务接口
 * 可以根据 nacos  配置 动态切换
 */

//@RefreshScope
@Component
public class MailServiceProxy {

    @Value("${mail.active-provider:aliyun}")
    private String activeProvider;

    private final MailServiceFactory factory;

    public MailServiceProxy(MailServiceFactory factory) {
        this.factory = factory;
    }

    // 私有方法：根据配置获取当前激活的服务
    private MailService getCurrentService() {
        return factory.getActiveService(this.activeProvider);
    }

    // 严格遵循需求定义的接口签名
    public boolean sendEmail(String url, String payload) {
        return getCurrentService().sendEmail(url, payload);
    }

    public boolean sendEmailBatch(String[] urls, String payload) {
        return getCurrentService().sendEmailBatch(urls, payload);
    }

    public boolean validateEmailAddress(String url) {
        return getCurrentService().validateEmailAddress(url);
    }
}
