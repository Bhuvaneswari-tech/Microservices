package com.example.monolith.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.monolith.entity.Order;
import com.example.monolith.entity.Product;
import com.example.monolith.repository.OrderRepository;
import com.example.monolith.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	public Order placeOrder(Order order) {
		Product product = productRepo.findById(order.getProduct().getId())
				.orElseThrow(()->new RuntimeException("Product nut found"));
		order.setProduct(product);
		return orderRepo.save(order);
	}
	
	public List<Order> getAllOrders(){
		return orderRepo.findAll();
	}
}

/*
 {
 "customername":"alice",
  "quantity": 2,
  "product": {
    "id": 101
  } 
  
  productId from Product and productId from  Order - both are checked
 */
