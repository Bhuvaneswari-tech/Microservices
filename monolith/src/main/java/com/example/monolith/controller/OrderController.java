package com.example.monolith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.monolith.entity.Order;
import com.example.monolith.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<Order> placeOrder(@RequestBody Order order){
		return ResponseEntity.ok(orderService.placeOrder(order));
	}
	
	@GetMapping
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}

}
