package com.sda.soamail.service.impl;

import com.sda.soamail.proxy.MailServiceProxy;
import com.sda.soamail.service.EmailWebService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

import jakarta.jws.WebService;

@Service
@WebService(
        serviceName = "EmailWebService",
        targetNamespace = "http://soamail.sda.com/ws",
        endpointInterface = "com.sda.soamail.service.EmailWebService"
)
public class EmailWebServiceImpl implements EmailWebService {

    @Resource
    private MailServiceProxy proxy;

    @Override
    public String sendEmail( String url, String payload) {
        boolean result = proxy.sendEmail( url, payload);
        return result ? "Y" : "N";
    }

    @Override
    public String sendEmailBatch( String[] urls, String payload) {
        boolean result = proxy.sendEmailBatch(urls, payload);
        return result ? "Y" : "N";
    }

    @Override
    public String validateEmailAddress( String url) {
        boolean result = proxy.validateEmailAddress(url);
        return result ? "Y" : "N";
    }
}