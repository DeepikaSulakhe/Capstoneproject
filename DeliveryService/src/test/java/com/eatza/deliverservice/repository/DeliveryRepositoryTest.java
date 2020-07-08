//package com.eatza.deliverservice.repository;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import java.util.Optional;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.context.junit4.SpringRunner;
//import com.eatza.deliverservice.model.Delivery;
//
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class DeliveryRepositoryTest {
//
//	DeliveryRepository deliveryRepo;
//	
//	@Before
//    public void setUp() {
//		Delivery delivery = new Delivery(1L,1L,1L,"Not Yet Deliver");
//		deliveryRepo.save(delivery);
//    }
//	
//	 @After
//	    public void destroyRepo() {
//		 deliveryRepo.deleteAll();
//	    }
//	
//	 @Test
//	public void findAll() {
//		Pageable pageable = PageRequest.of(1, 10);
//		Page<Delivery> deliveryList=deliveryRepo.findAll(pageable);
//		assertEquals(1, deliveryList.getTotalElements());
//	}
//	
//	 @Test
//	    public void test_save() {
//		 Delivery delivery = new Delivery(10L,20L,30L,"Not Yet Deliver");
//		 Delivery responseObject= deliveryRepo.save(delivery);
//	        assertNotNull(responseObject);
//	        assertEquals(delivery.getCustomerId(), responseObject.getCustomerId());
//	    }
//	 @Test
//	    public void testFindByCustomerId() {
//	        Delivery delivery = new Delivery(20L,20L,30L,"Not Yet Deliver");
//	        deliveryRepo.save(delivery);
//	        Optional<Delivery> responseObject= deliveryRepo.findById(20L);
//	        assertNotNull(responseObject);
//	        assertEquals(delivery.getCustomerId(),responseObject.get().getRestaurantId());
//	    }
//	
//}
