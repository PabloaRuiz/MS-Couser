package com.business.hrpayroll.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // singleton de um objeto do tipo Rest Template
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
