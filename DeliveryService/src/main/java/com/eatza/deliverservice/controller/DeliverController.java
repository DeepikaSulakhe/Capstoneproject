package com.eatza.deliverservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.eatza.deliverservice.dto.DeliveyDto;
import com.eatza.deliverservice.exception.DeliveryException;
import com.eatza.deliverservice.exception.ItemDeliverdException;
import com.eatza.deliverservice.model.Delivery;
import com.eatza.deliverservice.service.DeliveryService;


@RestController
public class DeliverController {

	private static final Logger logger = LoggerFactory.getLogger(DeliverController.class);
	
	@Autowired
	DeliveryService service;
	
	//@PostMapping("/logging")
	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group.id}")
	public ResponseEntity<Delivery> logginOrderToDelivery(@RequestBody DeliveyDto deliveryDto) throws DeliveryException{
		logger.info("Data - " + deliveryDto.toString() + " recieved");
		logger.debug("In Deliver Items,Calling the service method");
		System.out.println("Item\n" +deliveryDto);
		Delivery deliver=this.service.loggingOrder(deliveryDto);
		logger.debug("Logged Succesfully");
		return ResponseEntity.status(HttpStatus.OK).body(deliver);
	}
	@PutMapping("/delivery/{orderId}")
	public ResponseEntity<Delivery> deliveringItems(@RequestHeader String authorization,@PathVariable Long orderId) 
			throws ItemDeliverdException, DeliveryException{
		logger.debug("In Deliver Items,Calling the service method");
		Delivery deliverItem=service.deliverItems(orderId);
		logger.debug("Deliverd Successfully");
		return ResponseEntity.status(HttpStatus.OK).body(deliverItem);
	}
	
}
