package com.example.demo.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RabbitListener(queues="spice-jet-orders")
public class Subscriber {

	@RabbitHandler
	public void receive(String incomingMessage) {
		log.info(incomingMessage);
	}
}
