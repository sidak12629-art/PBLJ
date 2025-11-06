package com.example.springdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MessageService messageService() {
        return new MessageServiceImpl();
    }

    @Bean
    public App app() {
        return new App(messageService());
    }
}
