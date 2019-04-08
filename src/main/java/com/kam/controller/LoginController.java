package com.kam.controller;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@Autowired
	private DefaultMQProducer defaultMQProducer;
	/**
	 * @author Admin
	 * 
	 * */
	@RequestMapping(name="login.html",method=RequestMethod.GET)
	public String login() {
		System.out.println("开始发送消息");
		
		try {
			for(int i=0;i<5;i++) {
				String zhi = "goods pocketMQ";
				Message sends = new Message("orderTopic","aaa",zhi.getBytes());
				SendResult resou = defaultMQProducer.send(sends);
				System.out.println("消息发送响应信息"+resou.toString());
			}
			
			return "one";
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
		return "one";
	}
}
