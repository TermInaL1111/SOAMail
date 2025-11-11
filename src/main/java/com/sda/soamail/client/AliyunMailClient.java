package com.sda.soamail.client;


import com.aliyun.dm20151123.models.SingleSendMailRequest;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.dm20151123.Client;

import com.sda.soamail.config.AliyunMailConfig;
import com.sda.soamail.dto.MailSendRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AliyunMailClient {

    private final AliyunMailConfig config;

    public AliyunMailClient(AliyunMailConfig config) {
        this.config = config;
    }

    public boolean sendMail(MailSendRequest req) {
        try {
            // 创建配置
            Config cfg = new Config()
                    .setAccessKeyId(config.getAccessKeyId())
                    .setAccessKeySecret(config.getAccessKeySecret())
                    .setRegionId(config.getRegionId())
                    .setEndpoint("dm.aliyuncs.com");

            // 创建阿里云客户端
            Client client = new Client(cfg);

            // 组装请求参数
            SingleSendMailRequest request = new SingleSendMailRequest()
                    .setAccountName(config.getFromAddress())
                    .setAddressType(1)
                    .setToAddress(req.getToAddress())
                    .setSubject(req.getSubject())
                    .setHtmlBody(req.getHtmlBody());

            // 调用发送
            client.singleSendMail(request);
            return true;
        } catch (Exception e) {
           // e.printStackTrace();
            log.error("error:{ }",e);
            return false;
        }
    }
}
