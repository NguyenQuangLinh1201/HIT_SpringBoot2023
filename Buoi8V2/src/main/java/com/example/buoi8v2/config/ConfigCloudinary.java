package com.example.buoi8v2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigCloudinary {
    @Bean
    Cloudinary configCloudinary(){
        Map<String, String> config = new HashMap<>();
        config.put("api_key", "847693475319236");
        config.put("api_secret", "hwIgdq74JRGJ9-RYB9E3hmrOckg");
        config.put("cloud_name", "dptooxupy");
        return new Cloudinary(config);
    }
}
