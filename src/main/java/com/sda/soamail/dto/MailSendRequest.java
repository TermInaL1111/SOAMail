package com.sda.soamail.dto;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MailSendRequest {
    private String toAddress;    // 收件人
  //  private String fromAddress;  // 发件人
   // private String subject;      // 主题
    private String htmlBody;     // 内容
}