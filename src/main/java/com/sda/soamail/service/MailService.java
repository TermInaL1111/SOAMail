package com.sda.soamail.service;

//SOA 的服务契约定义。
//定义了邮件服务这个业务能力对外暴露的功能（契约）
public interface MailService {
    boolean sendEmail(String _url, String _payload);
    boolean sendEmailBatch(String[] _url, String _payload);
    boolean validateEmailAddress(String _url);
}