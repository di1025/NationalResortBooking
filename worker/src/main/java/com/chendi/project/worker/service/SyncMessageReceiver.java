package com.chendi.project.worker.service;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

@Component
public class SyncMessageReceiver {

//    @Qualifier("connectionFactory")
//    SQSConnectionFactory connectionFactory;

//    @Value("#{sqsAWSPropertiesSpringBoot['sqs.name']}")
//    protected String queueName;


    public void receiveSyncMessages() throws JMSException {

        AmazonSQS sqsClient= AmazonSQSClientBuilder.defaultClient();

        SQSConnectionFactory connectionFactory = new SQSConnectionFactory(new ProviderConfiguration(), sqsClient);

        SQSConnection connection = connectionFactory.createConnection();

        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        MessageConsumer consumer = session.createConsumer(session.createQueue("NationalParkReservation-dev"));
//        TODO change concurrent =1

        MessageListener myListener = new ConsumerMessageListener("Consumer");

        consumer.setMessageListener(myListener);

        connection.start();

//        Message receivedMessage = consumer.receive(1000);
//
//
//// Cast the received message as TextMessage and display the text
//        if (receivedMessage != null) {
//            System.out.println("Received: " + ((TextMessage) receivedMessage).getText());
//            System.out.println("Received: " + ((TextMessage) receivedMessage).getText());
//            System.out.println("Group id: " + receivedMessage.getStringProperty("JMSXGroupID"));
//            System.out.println("Message deduplication id: " + receivedMessage.getStringProperty("JMS_SQS_DeduplicationId"));
//            System.out.println("Message sequence number: " + receivedMessage.getStringProperty("JMS_SQS_SequenceNumber"));
//            sqsClient.deleteMessage("https://sqs.us-east-1.amazonaws.com/452279762309/NationalParkReservation-dev", receivedMessage.getJMSMessageID());
//        }
    }
}