package com.eatza.deliverservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eatza.deliverservice.controller.DeliverController;
import com.eatza.deliverservice.dto.DeliveyDto;
import com.eatza.deliverservice.exception.DeliveryException;
import com.eatza.deliverservice.exception.ItemDeliverdException;
import com.eatza.deliverservice.model.Delivery;
import com.eatza.deliverservice.repository.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	@Autowired
	DeliveryRepository deliveryRepo;
	private static final Logger logger = LoggerFactory.getLogger(DeliverController.class);

	@Override
	public Delivery loggingOrder(DeliveyDto deliveryDto) throws DeliveryException {
		logger.debug("In logging Order,Logging the order");
		try {
			Long restaurantId = deliveryDto.getRestaurantId();
			Long customerId = deliveryDto.getCustomerId();
			Long orderId = deliveryDto.getOrderId();
			Delivery deliverable = new Delivery(orderId, restaurantId, customerId, "Not Yet Deliver");
			logger.debug("Registering the Order");
			Delivery item = deliveryRepo.save(deliverable);
			
			System.out.println("ITEM\n"+item);
			logger.debug("Order added Succesfully");
			return deliverable;
		} catch (Exception e) {
			throw new DeliveryException("Delivery Issue,Something went wrong");
		}
	}

	@Override
	public Delivery deliverItems(Long orderId) throws DeliveryException, ItemDeliverdException {
		logger.debug("In deliver Items,Delivering the order");
		Delivery items = this.deliveryRepo.getDeliveryById(orderId);
		System.out.println("Item\n" + items);
		if (items.getRecord().equalsIgnoreCase("Not Yet Deliver")) {
			items.setRecord("Delivered");
			this.deliveryRepo.save(items);
		} else {
			throw new ItemDeliverdException("Order delivered previously");
		}
		return items;
	}
}
