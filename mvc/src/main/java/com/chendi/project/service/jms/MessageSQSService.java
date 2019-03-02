package com.chendi.project.service.jms;

import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//use the default construction
public class MessageSQSService {
    private AmazonSQS sqs;
    private String messageId;


    @Value("#{sqsAWSProperties['sqs.url']}")
    private String sqsUrl;


    public MessageSQSService(@Autowired AmazonSQS sqs){
        this.sqs=sqs;
    };

    public void sendMessageRequest(String messageBody) {
        SendMessageRequest sendMsgRequest = new SendMessageRequest()
                .withQueueUrl(sqsUrl)
                .withMessageBody(messageBody)
                .withDelaySeconds(5);
        sqs.sendMessage(sendMsgRequest);
    }

    public void setSqsUrl(String url){
        this.sqsUrl=url;
    }
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }


    List<Message> messages = sqs.receiveMessage(sqsUrl).getMessages();


    public void deleteSQSMessage(){
        for (Message m : messages) {
            sqs.deleteMessage(sqsUrl, m.getReceiptHandle());
        }

    }
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