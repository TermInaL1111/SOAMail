package com.sda.soamail.service.impl;

import com.sda.soamail.proxy.MailServiceProxy;
import com.sda.soamail.service.EmailWebService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

import javax.jws.WebService;

@Service
@WebService(
        serviceName = "EmailWebService",
        targetNamespace = "http://example.com/emailsvc/ws", // 自定义命名空间
        endpointInterface = "com.sda.soamail.service.impl.EmailWebService"
)
public class EmailWebServiceImpl implements EmailWebService {

    @Resource
    private MailServiceProxy proxy;

    @Override
    public String sendEmail(String provider, String url, String payload) {
        boolean result = proxy.sendEmail(provider, url, payload);
        return result ? "Y" : "N";
    }

    @Override
    public String sendEmailBatch(String provider, String[] urls, String payload) {
        boolean result = proxy.sendEmailBatch(provider, urls, payload);
        return result ? "Y" : "N";
    }

    @Override
    public String validateEmailAddress(String provider, String url) {
        boolean result = proxy.validateEmailAddress(provider, url);
        return result ? "Y" : "N";
    }
}