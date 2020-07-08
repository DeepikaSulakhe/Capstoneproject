package com.eatza.deliverservice.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="DeliveryData")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class Delivery {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Long orderId;
private Long restaurantId;
private Long customerId;
private String record;

@UpdateTimestamp
private LocalDateTime updTime;

public Delivery(Long orderId, Long restaurantId, Long customerId, String status) {
	super();
	this.orderId = orderId;
	this.restaurantId = restaurantId;
	this.customerId = customerId;
	this.record = status;
}
}
