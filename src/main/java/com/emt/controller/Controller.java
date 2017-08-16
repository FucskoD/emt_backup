package com.emt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emt.entity.Order;
import com.emt.repository.OrderRepository;

@RestController
public class Controller {
	private OrderRepository orderRepository;
	
	@Autowired
	public void setRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	@RequestMapping("/")
	public String allOrders() {
		List<Order> orderList = new ArrayList<Order>();
		orderRepository.findAll().forEach(orderList::add);
		
		return orderList.toString();
	}
	
//	@RequestMapping(value="/{locationId:[\\d]+}", method = RequestMethod.GET)
//	@ResponseBody
	@RequestMapping("/{locationId:[\\d]+}")
	public String ordersByLocationId(@PathVariable long locationId) {
		List<Order> orderList = orderRepository.findByLocationId(((Long)locationId).toString());
		return orderList.toString();
	}
}
