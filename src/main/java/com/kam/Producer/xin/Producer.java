package com.kam.Producer.xin;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;

import com.kam.util.xian;

public class Producer {
        public static void main(String[] args) {
        	DefaultMQProducer producer = new DefaultMQProducer("newzu");
    		producer.setNamesrvAddr("38.21.240.103:9876");
    		producer.setVipChannelEnabled(false);
    		producer.setMaxMessageSize(128);
    		producer.setCompressMsgBodyOverHowmuch(4096);
    		try {
    			producer.start();
    		} catch (MQClientException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		byte[] by =new byte[2048];
    		for(int i=0;i<by.length;i++) {
    			by[i] = (byte)i;
    		}
    		String zhi = new SimpleDateFormat("yyyy-MM-hh HH:mm:ss").format(new Date());
   			Message msg = new Message("mytopic","TagA",zhi,by);
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
		/*
		 * for(int i=0;i<100;i++) { xian x = new xian(producer); x.start(); }
		 */
    		
   		producer.shutdown();
        	
		}
		
	
	
}
