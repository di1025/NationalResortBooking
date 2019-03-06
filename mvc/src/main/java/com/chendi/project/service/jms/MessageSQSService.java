package com.chendi.project.service.jms;

import com.amazonaws.services.appstream.model.Session;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service//use the default construction
public class MessageSQSService {
    private AmazonSQS sqs;
    private String messageId;


    @Value("#{sqsAWSProperties['sqs.url']}")
    private String sqsUrl;


    public MessageSQSService(@Autowired AmazonSQS sqs){
        this.sqs=sqs;
    };

    public void sendMessageRequest(String messageBody, Integer delaySed) {
        SendMessageRequest sendMsgRequest = new SendMessageRequest()
                .withQueueUrl(sqsUrl)
                .withMessageBody(messageBody)
                .withDelaySeconds(delaySed);
        sqs.sendMessage(sendMsgRequest);
    }

//    public void sendMessageRequest(Map<String, MessageAttributeValue> messageBody, Integer delaySed) {
//        SendMessageRequest sendMsgRequest = new SendMessageRequest()
//                .withQueueUrl(sqsUrl)
//                .withMessageAttributes(messageBody)
//                .withDelaySeconds(delaySed);
//        sqs.sendMessage(sendMsgRequest);

//    }

    public void setSqsUrl(String url){
        this.sqsUrl=url;
    }
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }







//    SQSConnectionFactory connectionFactory = new SQSConnectionFactory(
//            new ProviderConfiguration(),
//            AmazonSQSClientBuilder.defaultClient()
//    );
//    SQSConnection connection = connectionFactory.createConnection();
//
//    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//
//    TextMessage message = session.createTextMessage("Hello World!");
//
//// Send the message
//producer.send(message);
//System.out.println("JMS Message " + message.getJMSMessageID());



//    List<Message> messages = sqs.receiveMessage(sqsUrl).getMessages();








//
//
//    public void deleteSQSMessage(){
//        for (Message m : messages) {
//            sqs.deleteMessage(sqsUrl, m.getReceiptHandle());
//        }

//    }
    // Send multiple messages to the queue
//    SendMessageBatchRequest send_batch_request = new SendMessageBatchRequest()
//            .withQueueUrl(queueUrl)
//            .withEntries(
//                    new SendMessageBatchRequestEntry(
//                            "msg_1", "Hello from message 1"),
//                    new SendMessageBatchRequestEntry(
//                            "msg_2", "Hello from message 2")
//                            .withDelaySeconds(10));
//        sqs.sendMessageBatch(send_batch_request);

}