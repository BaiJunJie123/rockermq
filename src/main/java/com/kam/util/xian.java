package com.kam.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class xian extends Thread{
	public DefaultMQProducer producer;
	
	@Override
	public void run() {
		   for(int i=0;i<500;i++) {
			   String zhi = new SimpleDateFormat("yyyy-MM-hh HH:mm:ss").format(new Date());
   			Message msg = new Message("mytopic","TagA",zhi,("hello123").getBytes());
   		   try {
   			SendResult send = producer.send(msg,10000);
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
	public xian(DefaultMQProducer producer) {
		this.producer = producer;
	}
}
