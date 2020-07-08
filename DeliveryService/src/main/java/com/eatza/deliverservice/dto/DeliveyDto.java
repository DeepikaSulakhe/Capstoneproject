package com.eatza.deliverservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
//@Setter
@NoArgsConstructor
public class DeliveyDto {

	private Long orderId;
	private Long customerId;
	private Long restaurantId;

	public DeliveyDto(Long orderId, Long customerId, Long restaurantId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
	}
}
