package com.example.demo.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Publisher {

	@Autowired
	RabbitTemplate template;
	
	@Autowired
	Queue queue;
	
	long nos=50;
	int i=1;
	@Scheduled(fixedDelay=1000,initialDelay=100)
	public void send() {
		template.convertAndSend(queue.getName(),"Vegan Meals - "+nos+" units");
		
		log.info(i++ + " One food order sent");
		
		nos=nos+10;
	}
}
