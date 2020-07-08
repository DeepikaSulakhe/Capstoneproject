package com.eatza.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class DeliveryResponseDto {
    private Long id;
	private Long orderId;
	private Long customerId;
	private Long restaurantId;
	private String record;
	
	public DeliveryResponseDto(Long orderId, Long customerId, Long restaurantId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
	}
	

}
