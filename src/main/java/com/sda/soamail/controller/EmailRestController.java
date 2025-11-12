package com.sda.soamail.controller;

import com.sda.soamail.proxy.MailServiceProxy;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailRestController {

    private final MailServiceProxy proxy;

    public EmailRestController(MailServiceProxy proxy) {
        this.proxy = proxy;
    }

    @PostMapping("/send")
    public String send(@RequestParam String url,
                       @RequestParam String payload) {
        return proxy.sendEmail( url, payload) ? "Y" : "N";
    }
    @PostMapping("/sendBatch")
    public String sendBatch(@RequestBody String[] urls,
                            @RequestParam String payload) {
        return proxy.sendEmailBatch(urls, payload) ? "Y" : "N";
    }
    @GetMapping("/validate")
    public String validate(@RequestParam String url) {
        return proxy.validateEmailAddress(url) ? "Y" : "N";
    }
}
