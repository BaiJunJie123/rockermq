package com.kam.Producer;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.util.internal.StringUtil;
@Configuration
public class MQProducerConfiguration {
	 @Value("${spring.application.name}")
	private String groupName;
	 @Value("${rocketmq.producer.namesrvAddr}")
	private String namesrvAddr;
	 @Value("${rocketmq.producer.maxMessageSize}")
	 private Integer maxMessageSize;
	 @Value("${rocketmq.producer.sendMsgTimeout}")
	 private Integer sendMsgTimeout;
	 
	 @Value("${rocketmq.producer.retryTimesWhenSendFailed}")
     private Integer retryTimesWhenSendFailed;
	 @Bean
	 public DefaultMQProducer getRocketMQProducer() {
		 if(StringUtils.isEmpty(this.groupName)) {
			 try {
				throw new Exception("groupName空的");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 if(StringUtils.isEmpty(this.namesrvAddr)) {
			 try {
					throw new Exception("namesrvAddr空的");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 DefaultMQProducer producer = new DefaultMQProducer(this.groupName);
		 producer.setNamesrvAddr(this.namesrvAddr);
		 producer.setCreateTopicKey("aaa");
		//如果需要同一个jvm中不同的producer往不同的mq集群发送消息，需要设置不同的instanceName
	        //producer.setInstanceName(instanceName);
		 if(this.maxMessageSize!=null) {
			 producer.setMaxMessageSize(this.maxMessageSize);
		 }
		 if(this.retryTimesWhenSendFailed!=null) {
			 producer.setRetryTimesWhenSendFailed(this.retryTimesWhenSendFailed);
		 }
		 try {
			 System.out.println("小发送给我上");
			 producer.start();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return producer;
		 
	 }
	
}
