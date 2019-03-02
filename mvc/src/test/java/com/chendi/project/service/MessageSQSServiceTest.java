package com.chendi.project.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.chendi.project.config.AppConfig;
import com.chendi.project.service.jms.MessageSQSService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class MessageSQSServiceTest {

    @Autowired
    private MessageSQSService messageSQSService;

    @Autowired
    public AmazonSQS sqs;

    @Value("#{sqsAWSProperties['sqs.url']}")
    private String sqsUrl;


    @Test
    public void sendMessageRequestTest(){
        messageSQSService.sendMessageRequest("test1-message");
        SendMessageRequest sendMsgRequest = new SendMessageRequest()
                .withQueueUrl(sqsUrl)
                .withMessageBody("test1-message")
                .withDelaySeconds(5);
        verify(sqs,times(1)).sendMessage(sendMsgRequest);
        messageSQSService.sendMessageRequest(null);
        verify(sqs,times(1)).sendMessage(sendMsgRequest);
    }


}
