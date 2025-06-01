package com.capston_design.fkiller.itoms.service_request_management;

import com.capston_design.fkiller.itoms.service_request_management.config.FeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableJpaAuditing
@SpringBootApplication
@EnableFeignClients(defaultConfiguration = FeignClient.class)
public class ServiceRequestManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRequestManagementApplication.class, args);
    }

}
