package com.sda.soamail.client;


import com.aliyun.dm20151123.models.SingleSendMailRequest;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.dm20151123.Client;

import com.sda.soamail.config.AliyunMailConfig;
import com.sda.soamail.dto.MailSendRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class AliyunMailClient {

    private final AliyunMailConfig config;

    private static final String DEFAULT_SUBJECT = "系统通知"; //  固定默认主题

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
 // 1=收件人, 2=抄送, 3=密送
            // 组装请求参数
            SingleSendMailRequest request = new SingleSendMailRequest()
                    .setAccountName(config.getFromAddress())
                    .setAddressType(1)
                    .setReplyToAddress(false) // 不需要回复地址
                    .setToAddress(req.getToAddress())
                    .setSubject(DEFAULT_SUBJECT)
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
    // 在 AliyunMailClient 中添加批量发送方法
    public boolean sendMailBatch(List<MailSendRequest> requests) {
        try {
            // TODO: 实现真正的批量发送逻辑
            for (MailSendRequest req : requests) {
                if (!sendMail(req)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            log.error("Batch send mail error: ", e);
            return false;
        }
    }
}
