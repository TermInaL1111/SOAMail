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
    public String send(@RequestParam(required = false) String provider,
                       @RequestParam String url,
                       @RequestParam String payload) {
        return proxy.sendEmail(provider, url, payload) ? "Y" : "N";
    }

    @PostMapping("/sendBatch")
    public String sendBatch(@RequestParam(required = false) String provider,
                            @RequestBody String[] urls,
                            @RequestParam String payload) {
        return proxy.sendEmailBatch(provider, urls, payload) ? "Y" : "N";
    }

    @GetMapping("/validate")
    public String validate(@RequestParam(required = false) String provider,
                           @RequestParam String url) {
        return proxy.validateEmailAddress(provider, url) ? "Y" : "N";
    }
}
