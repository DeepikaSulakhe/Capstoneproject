package com.eatza.deliverservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.eatza.deliverservice.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

	@Query(value="SELECT d FROM  Delivery d WHERE d.orderId=:id")
	public Delivery getDeliveryById(@Param("id") Long orderId); 
}
