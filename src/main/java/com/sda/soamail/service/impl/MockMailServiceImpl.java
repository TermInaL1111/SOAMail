package com.sda.soamail.service.impl;


import com.sda.soamail.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("mockMailService") // 注意：bean名称必须是 mockMailService
public class MockMailServiceImpl implements MailService {

    private static final Logger log = LoggerFactory.getLogger(MockMailServiceImpl.class);

    @Override
    public boolean sendEmail(String email, String payload) {
        // 模拟特定邮箱发送失败
        if (email.contains("fail")) {
            log.error("【MOCK】模拟发送失败: {}", email);
            return false;
        }
        log.info("【MOCK】发送邮件到: {}", email);
        return true;
    }


    @Override
    public boolean sendEmailBatch(String[] emails, String payload) {
        log.info("【MOCK】批量发送邮件到: {} 个收件人", emails.length);
        for (String email : emails) {
            log.info("【MOCK】 - {}", email);
        }
        return true; // 模拟发送成功
    }

    @Override
    public boolean validateEmailAddress(String email) {
        log.info("【MOCK】验证邮箱: {}", email);
        // 简单的邮箱格式验证（实际会调用真实验证逻辑）
        boolean isValid = email != null && email.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");
        log.info("【MOCK】邮箱 {} 验证结果: {}", email, isValid ? "有效" : "无效");
        return isValid;
    }
}
