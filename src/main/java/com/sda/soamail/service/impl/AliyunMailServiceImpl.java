package com.sda.soamail.service.impl;

import com.sda.soamail.client.AliyunMailClient;
import com.sda.soamail.dto.MailSendRequest;
import com.sda.soamail.service.MailService;
import com.sda.soamail.utils.EmailValidator;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("aliyunMailService")
public class AliyunMailServiceImpl implements MailService {

    private final AliyunMailClient client;

    public AliyunMailServiceImpl(AliyunMailClient client) {
        this.client = client;
    }

    @Override
    public boolean sendEmail(String url, String payload) {
        if (!EmailValidator.isValid(url)) return false;
        return client.sendMail(new MailSendRequest(url,  payload));
    }

    @Override
    public boolean sendEmailBatch(String[] urls, String payload) {
        if (urls == null || urls.length == 0) return false;
        return Arrays.stream(urls)
                .filter(EmailValidator::isValid)
                .allMatch(addr -> client.sendMail(new MailSendRequest(addr,  payload)));
    }

    @Override
    public boolean validateEmailAddress(String url) {
        return EmailValidator.isValid(url);
    }
}