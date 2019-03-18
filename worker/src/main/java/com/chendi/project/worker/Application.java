package com.chendi.project.worker;

<<<<<<< HEAD
//import com.chendi.project.worker.service.SQSMessageService;
import com.chendi.project.worker.service.SyncMessageReceiver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.jms.JMSException;
=======
import java.util.Arrays;

import com.chendi.project.worker.service.SQSMessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
>>>>>>> a995a57da298914c67bafe2a5c39d7d11e7cd684

@SpringBootApplication
public class Application {

<<<<<<< HEAD
    public static void main(String[] args) throws JMSException {
        ApplicationContext app=SpringApplication.run(Application.class, args);
        SyncMessageReceiver syncMessageReceiver = app.getBean(SyncMessageReceiver.class);
        syncMessageReceiver.receiveSyncMessages();
=======
    public static void main(String[] args) {
        ApplicationContext app=SpringApplication.run(Application.class, args);
        SQSMessageService messageService=app.getBean(SQSMessageService.class);
        messageService.receiveMessage();
>>>>>>> a995a57da298914c67bafe2a5c39d7d11e7cd684
    }

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
//    }

}