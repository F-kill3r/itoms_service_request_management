package com.capston_design.fkiller.itoms.service_request_management.config;

import org.springframework.cloud.openfeign.clientconfig.FeignClientConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClient {
    public FeignClientConfigurer feignClientConfigurer() {
        return new FeignClientConfigurer() {};
    }
}
