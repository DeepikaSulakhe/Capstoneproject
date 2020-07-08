package com.eatza.deliverservice.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import org.junit.Test;
import com.eatza.deliverservice.dto.DeliveyDto;
import com.eatza.deliverservice.exception.DeliveryException;
import com.eatza.deliverservice.exception.ItemDeliverdException;
import com.eatza.deliverservice.model.Delivery;
import com.eatza.deliverservice.repository.DeliveryRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class DeliveryServiceTest {

	@InjectMocks
	private DeliveryServiceImpl serviceImpl;

	@Mock
	private DeliveryRepository deliveryRepo;

	@Mock
	private RestTemplate restTemplate;

	@Test
	public void loggingOrder() throws DeliveryException {
		DeliveyDto deliverItemDto = new DeliveyDto(1L, 1L, 1L);
		Delivery item = new Delivery(1L, 1L, 1L, "Not Yet Deliver");
		Delivery logged = new Delivery(1L, 1L, 1L, 1L, "Not Yet Deliver", java.time.LocalDateTime.now());
		logged.setId(1L);
		logged.setUpdTime(java.time.LocalDateTime.now());
		System.out.println("Items\n" + logged);
		when(deliveryRepo.save(any(Delivery.class))).thenReturn(logged);
		assertNotNull(serviceImpl.loggingOrder(deliverItemDto));
	}

	@Test
	public void deliverOrder_success() throws DeliveryException, ItemDeliverdException {
		Delivery item = new Delivery(1L, 1L, 1L, 1L, "Not Yet Deliver", java.time.LocalDateTime.now());
		lenient().when(deliveryRepo.getDeliveryById(any())).thenReturn(item);
		Delivery updatedItem = new Delivery(1L, 1L, 1L, 1L, "Delivered", java.time.LocalDateTime.now());
		when(deliveryRepo.save(any(Delivery.class))).thenReturn(updatedItem);
		Delivery returnedItem = deliveryRepo.save(updatedItem);
		assertEquals("Delivered", returnedItem.getRecord());
		assertNotNull(serviceImpl.deliverItems(anyLong()));
	}

	@Test(expected = ItemDeliverdException.class)
	public void deliverOrder2_fail() throws DeliveryException, ItemDeliverdException {
		Delivery item = new Delivery(1L, 1L, 1L, 1L, "Delivered", java.time.LocalDateTime.now());
		lenient().when(deliveryRepo.getDeliveryById(anyLong())).thenReturn(item);
		Delivery updatedItem = new Delivery(1L, 1L, 1L, 1L, "Delivered", java.time.LocalDateTime.now());
		serviceImpl.deliverItems(anyLong());
	}

}
