package com.sda.soamail;

import com.sda.soamail.proxy.MailServiceProxy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SoaMailApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private MailServiceProxy mailServiceProxy;

    @Test
    void testSendEmail() {
        boolean result = mailServiceProxy.sendEmail("test@example.com", "测试内容");
        assertTrue(result);
    }
    @Test
    void testSendEmailerror(){
        boolean result = mailServiceProxy.sendEmail("testfail@example.com", "测试内容");
        assertFalse(result);
    }

    @Test
    void testValidateEmail() {
        assertTrue(mailServiceProxy.validateEmailAddress("test@example.com"));
        assertFalse(mailServiceProxy.validateEmailAddress("invalid-email"));
    }
}
