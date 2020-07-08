package com.eatza.deliverservice.service;

import org.springframework.stereotype.Service;

import com.eatza.deliverservice.dto.DeliveyDto;
import com.eatza.deliverservice.exception.DeliveryException;
import com.eatza.deliverservice.exception.ItemDeliverdException;
import com.eatza.deliverservice.model.Delivery;

@Service
public interface DeliveryService {

	Delivery loggingOrder(DeliveyDto deliveryDto) throws DeliveryException;

	Delivery deliverItems(Long orderId) throws ItemDeliverdException, DeliveryException;

}
