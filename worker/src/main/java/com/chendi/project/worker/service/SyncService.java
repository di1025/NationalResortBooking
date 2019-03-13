//package com.chendi.project.worker.service;
//
//
//import com.amazonaws.services.sqs.AmazonSQS;
//import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
//import com.amazonaws.services.sqs.model.Message;
//import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class SyncService {
//    protected final Logger logger = LoggerFactory.getLogger(getClass());
//    private AmazonSQS sqsClient= AmazonSQSClientBuilder.defaultClient();
//
//    public String getQueueUrl(String queueName) {
//        String queueUrl = sqsClient.getQueueUrl(queueName).getQueueUrl();
//        return queueUrl;
//    }
//
//
//    @JmsListener(destination = "NationalParkReservation-dev")
//    public void receiver(String m) throws IOException {
//        final ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest();
//        final List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).getMessages();
//        for (final Message message : messages) {
//            System.out.println("Message");
//            System.out.println("  MessageId:     " + message.getMessageId());
//            System.out.println("  ReceiptHandle: " + message.getReceiptHandle());
//            System.out.println("  MD5OfBody:     " + message.getMD5OfBody());
//            System.out.println("  Body:          " + message.getBody());
//            for (final Map.Entry<String, String> entry : message.getAttributes().entrySet()) {
//                System.out.println("Attribute");
//                System.out.println("  Name:  " + entry.getKey());
//                System.out.println("  Value: " + entry.getValue());
//            }
//            sqsClient.deleteMessage(getQueueUrl("NationalParkReservation-dev"), message.getReceiptHandle());
//        }
//    }
//}