package com.eatza.order.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import com.eatza.order.dto.DeliveryResponseDto;

@FeignClient(url="http://localhost:8086",name="DeliveryService")
public interface DeliverServiceClient {
    @PostMapping("/logging")
	public ResponseEntity<DeliveryResponseDto> loggingOrder(DeliveryResponseDto order);
}
