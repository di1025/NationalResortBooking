package com.chendi.project.worker;

//import com.chendi.project.worker.service.SQSMessageService;
import com.chendi.project.worker.service.SyncMessageReceiver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.jms.JMSException;

import com.chendi.project.worker.service.SQSMessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws JMSException {
        ApplicationContext app=SpringApplication.run(Application.class, args);
        SyncMessageReceiver syncMessageReceiver = app.getBean(SyncMessageReceiver.class);
        syncMessageReceiver.receiveSyncMessages();
//    public static void main(String[] args) {
//        ApplicationContext app=SpringApplication.run(Application.class, args);
//        SQSMessageService messageService=app.getBean(SQSMessageService.class);
//        messageService.receiveMessage();
//    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
    }

}