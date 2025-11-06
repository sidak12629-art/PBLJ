package com.example.transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BankService service = context.getBean(BankService.class);
        service.transfer(1, 2, 500.0);
        context.close();
    }
}
