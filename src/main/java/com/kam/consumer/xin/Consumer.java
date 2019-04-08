package com.kam.consumer.xin;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.junit.Test;

public class Consumer {
     @Test
	public void show() {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("newzu");
		consumer.setNamesrvAddr("38.21.240.103:9876");
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
		try {
			consumer.subscribe("mytopic", "*");
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		consumer.registerMessageListener(new MessageListenerConcurrently() {

			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				// TODO Auto-generated method stub
				MessageExt msg = msgs.get(0);
				try {
					String topic = msg.getTopic();
					String body = new String(msg.getBody(),"UTF-8");
				    String tag = msg.getTags();
				    System.out.println("topic"+topic+" ==body"+body+"===tag"+tag);
				}catch(Exception e) {
					e.printStackTrace();
					return ConsumeConcurrentlyStatus.RECONSUME_LATER;
				}
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
			
		});
		try {
			consumer.start();
			System.out.println("开始");
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
