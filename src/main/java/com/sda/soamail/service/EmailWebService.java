package com.sda.soamail.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;


//webservice
@WebService
public interface EmailWebService {
    @WebMethod
    String sendEmail( String url, String payload);

    @WebMethod
    String sendEmailBatch(String[] urls, String payload);

    @WebMethod
    String validateEmailAddress( String url);
}