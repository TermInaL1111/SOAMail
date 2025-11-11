package com.sda.soamail.proxy;

import com.sda.soamail.service.MailService;
import org.springframework.stereotype.Component;

/**
 * 对外统一调用邮件服务接口
 * 可以根据 provider 动态切换
 */
@Component
public class MailServiceProxy {

    private final MailServiceFactory factory;

    public MailServiceProxy(MailServiceFactory factory) {
        this.factory = factory;
    }

    /**
     * 根据 provider 动态选择邮件服务实现
     * provider = aliyun / aws / smtp
     */
    private MailService getService(String provider) {
        return factory.get(provider);
    }

    public boolean sendEmail(String provider, String url, String payload) {
        return getService(provider).sendEmail(url, payload);
    }

    public boolean sendEmailBatch(String provider, String[] urls, String payload) {
        return getService(provider).sendEmailBatch(urls, payload);
    }

    public boolean validateEmailAddress(String provider, String url) {
        return getService(provider).validateEmailAddress(url);
    }
}