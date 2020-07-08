package com.eatza.deliverservice.controller;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.eatza.deliverservice.model.Delivery;
import com.eatza.deliverservice.service.DeliveryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RunWith(SpringRunner.class)
@WebMvcTest(value= DeliverController.class)
public class DeliverControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DeliveryServiceImpl service;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private static final long EXPIRATIONTIME = 900000;
	String jwt="";
	String invalidjwt="";

	@Before
	public void setup() {
		jwt = "Bearer "+Jwts.builder().setSubject("user").claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME)).compact();
	}
	
//	@Test
//    public void logOrder() throws Exception {
//        Delivery deliverItem = new Delivery(1L, 1L, 1L, "Not Yet Deliver");
//        DeliveyDto deliverItemDto = new DeliveyDto(1L, 1L, 1L);
//        deliverItem.setStatus("Not Yet Deliver");
//        when(service.loggingOrder(any(DeliveyDto.class))).thenReturn(deliverItem);
//        RequestBuilder request = MockMvcRequestBuilders.post("/logging").contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(deliverItemDto));
//        mockMvc.perform(request).andExpect(status().is(200)).andReturn();
//    }
@Test
public void deliveringItems() throws Exception {
    when(service.deliverItems(anyLong()))
            .thenReturn(new Delivery(1L, 1L, 1L, 1L, "Delivered", java.time.LocalDateTime.now()));
    RequestBuilder request = MockMvcRequestBuilders.put("/delivery/1?")
            .accept(MediaType.APPLICATION_JSON_VALUE).header(HttpHeaders.AUTHORIZATION, jwt);
    mockMvc.perform(request).andExpect(status().is(200)).andReturn();
 }
}
