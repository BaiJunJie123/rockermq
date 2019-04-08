package com.kam.consumer;

import java.util.List;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
//监听器
@Component("MQConsumeMsgListenerProcessor")
public class MQConsumeMsgListenerProcessor implements MessageListenerConcurrently {

	@Override
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		// TODO Auto-generated method stub
		/*
		 * if(CollectionUtils.isEmpty(msgs)) { return
		 * ConsumeConcurrentlyStatus.CONSUME_SUCCESS; } MessageExt messageExt =
		 * msgs.get(0); String msg = new String(messageExt.getBody());
		 * if(messageExt.getTopic().equals("DemoTopic")) {
		 * if(messageExt.getTags().equals("bjj")) { int time =
		 * messageExt.getReconsumeTimes(); if(time==3) { return
		 * ConsumeConcurrentlyStatus.CONSUME_SUCCESS; } } }
		 */
		System.out.println("小监听给我上");
		for(MessageExt messageExts : msgs) {
			String topic = messageExts.getTopic();
			String tag = messageExts.getTags();
			String msgsc = new String(messageExts.getBody());
			   System.out.println("消费响应：,  msgBody : " + msgsc + ", tag:" + tag + ", topic:" + topic);
		}
		
		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}
 
}
