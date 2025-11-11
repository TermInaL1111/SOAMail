package com.sda.soamail.config;

import com.sda.soamail.service.impl.EmailWebServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.xml.ws.Endpoint;


@Configuration
public class CxfConfig {

    private final Bus bus;
    private final EmailWebServiceImpl emailWebService;

    public CxfConfig(Bus bus, EmailWebServiceImpl emailWebService) {
        this.bus = bus;
        this.emailWebService = emailWebService;
    }

    @Bean
    public Endpoint emailEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, emailWebService);
        endpoint.publish("/email"); // 最终访问路径：http://localhost:8080/services/email?wsdl
        return endpoint;
    }
}