package com.example.springdi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    private MessageService messageService;

    public App(MessageService messageService) {
        this.messageService = messageService;
    }

    public void showMessage() {
        System.out.println(messageService.getMessage());
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        App app = context.getBean(App.class);
        app.showMessage();
        context.close();
    }
}
