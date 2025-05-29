package com.capston_design.fkiller.itoms.service_request_management.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Service Request Management API Document",
                version = "1.0",
                description = "Itoms Service Request Management 기능을 수행하는 API document 페이지 입니다"
        )
)
public class SwaggerConfig {
        @Bean
        public OpenAPI serviceDeskOpenAPI() {
            return new OpenAPI();
        }
}

