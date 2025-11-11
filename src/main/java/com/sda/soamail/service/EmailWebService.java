package com.sda.soamail.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface EmailWebService {
    @WebMethod
    String sendEmail(String provider, String url, String payload);

    @WebMethod
    String sendEmailBatch(String provider, String[] urls, String payload);

    @WebMethod
    String validateEmailAddress(String provider, String url);
}