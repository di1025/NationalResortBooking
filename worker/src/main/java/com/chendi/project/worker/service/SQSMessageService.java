package com.chendi.project.worker.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SQSMessageService {

//    @Autowired
    private AmazonSQS sqsClient= AmazonSQSClientBuilder.defaultClient();
//    AmazonSQS client = AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();



//    @Value("${jms.queue.name}")
    private String queueNames="NationalParkReservation-dev";

    public String getQueueUrl(String queueName) {
        String queueUrl = sqsClient.getQueueUrl(queueName).getQueueUrl();
        return queueUrl;
    }

    public void receiveMessage() {
        final ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(getQueueUrl(queueNames));
        final List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).getMessages();
        for (final Message message : messages) {
            System.out.println("Message");
            System.out.println("  MessageId:     " + message.getMessageId());
            System.out.println("  ReceiptHandle: " + message.getReceiptHandle());
            System.out.println("  MD5OfBody:     " + message.getMD5OfBody());
            System.out.println("  Body:          " + message.getBody());
            for (final Map.Entry<String, String> entry : message.getAttributes().entrySet()) {
                System.out.println("Attribute");
                System.out.println("  Name:  " + entry.getKey());
                System.out.println("  Value: " + entry.getValue());
            }
            sqsClient.deleteMessage(getQueueUrl(queueNames), message.getReceiptHandle());
        }
    }

}
