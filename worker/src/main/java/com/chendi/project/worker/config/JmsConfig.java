package com.chendi.project.worker.config;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
<<<<<<< HEAD
import org.springframework.beans.factory.config.PropertiesFactoryBean;
=======
>>>>>>> a995a57da298914c67bafe2a5c39d7d11e7cd684
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
<<<<<<< HEAD
import org.springframework.core.io.ClassPathResource;
=======
>>>>>>> a995a57da298914c67bafe2a5c39d7d11e7cd684
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import javax.jms.Session;


@Configuration
@EnableJms
public class JmsConfig {

//    @Value("${aws.region}")
<<<<<<< HEAD
//    private String region="us-east-1";

    @Bean(name="connectionFactory")
    public SQSConnectionFactory getSQSConnectionFactory(){
    AmazonSQS amazonSQSClient = AmazonSQSClientBuilder.defaultClient();
=======
    private String region="us-east-1";

    @Bean(name="connectionFactory")
    public SQSConnectionFactory getSQSConnectionFactory(){
    AmazonSQS amazonSQSClient = AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).withRegion(region).build();
>>>>>>> a995a57da298914c67bafe2a5c39d7d11e7cd684
    SQSConnectionFactory factory = new SQSConnectionFactory(new ProviderConfiguration(),amazonSQSClient);
    return factory;
}

    @Bean
    public JmsTemplate getJmsTemplate(@Autowired SQSConnectionFactory connectionFactory){
    JmsTemplate jmsTemplate =new JmsTemplate(connectionFactory);
    return jmsTemplate;
    }

    @Bean
    public DynamicDestinationResolver getTopicDynamicDestinationResolver(){
    return new DynamicDestinationResolver();
}


    @Bean(name="jmsListenerContainerFactory")
    @DependsOn("connectionFactory")
    public DefaultJmsListenerContainerFactory getDefaultJmsListenerContainerFactory(@Autowired SQSConnectionFactory connectionFactory,@Autowired DynamicDestinationResolver dynamicDestinationResolver){
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setSessionTransacted(false);
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        jmsListenerContainerFactory.setDestinationResolver(dynamicDestinationResolver);
        jmsListenerContainerFactory.setConcurrency("1");
        jmsListenerContainerFactory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        return jmsListenerContainerFactory;
    }

    @Bean
    @Profile({"dev","test","stage","prod"})
    public AmazonSQS getSQSService(){
//        AmazonSQS client= AmazonSQSClientBuilder.defaultClient();
        AmazonSQS client = AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        return client;
    }
<<<<<<< HEAD

    @Bean(name = "sqsAWSPropertiesSpringBoot")
    public PropertiesFactoryBean getSQSProperties(){
        PropertiesFactoryBean sqsAWSProperties = new PropertiesFactoryBean();
        sqsAWSProperties.setLocation(new ClassPathResource("META-INF/env/sqsAWSPropertiesSpringBoot.properties"));
        return sqsAWSProperties;
    }
=======
>>>>>>> a995a57da298914c67bafe2a5c39d7d11e7cd684
}
