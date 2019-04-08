package com.kam.Producer.xin;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;

public class Producer {
   @Test
	public void show() {
		DefaultMQProducer producer = new DefaultMQProducer("newzu");
		producer.setNamesrvAddr("38.21.240.103:9876");
		try {
			producer.start();
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i =0;i<10;i++) {
			Message msg = new Message("mytopic","TagA","kk"+i,("hello"+i).getBytes());
		   try {
			SendResult send = producer.send(msg);
			System.out.println(send);
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemotingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MQBrokerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		producer.shutdown();
	}
	
}
