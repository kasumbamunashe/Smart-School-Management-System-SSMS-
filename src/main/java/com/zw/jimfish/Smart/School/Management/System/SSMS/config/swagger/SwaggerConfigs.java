package com.zw.jimfish.Smart.School.Management.System.SSMS.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfigs {
    @Bean
    public OpenAPI schoolManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("School Management API")
                        .description("API for Smart School Management System")
                        .version("1.0"));
    }
}
