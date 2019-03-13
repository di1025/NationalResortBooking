package com.chendi.project.worker.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener {
    private String consumerName;
    private int maxMessagesPerTask;

    public ConsumerMessageListener(String consumerName) {
        this.consumerName = consumerName;
//        this.maxMessagesPerTask=1;
    }



    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(consumerName + " received "
                    + textMessage.getText());
            //TODO send SMS
            message.acknowledge();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
