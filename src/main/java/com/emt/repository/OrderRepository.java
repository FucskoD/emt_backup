package com.emt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.emt.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
	List<Order> findByLocationId(String locationId);
	
}
