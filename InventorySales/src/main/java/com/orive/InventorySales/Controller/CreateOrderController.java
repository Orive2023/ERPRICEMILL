package com.orive.InventorySales.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.InventorySales.Entity.CreateOrder;
import com.orive.InventorySales.Service.CreateOrderService;

@RestController
@RequestMapping(value = "/order")
public class CreateOrderController {

	@Autowired
	private CreateOrderService createOrderService;
	
	@PostMapping(value = "/save")
	public CreateOrder save(@RequestBody CreateOrder createOrder)
	{
		return createOrderService.save(createOrder);
	}
	
	@GetMapping(name = "/get")
	public List<CreateOrder> getAll()
	{
		return createOrderService.getAll();
	}
	
	@GetMapping(value = "/getbyid/{createOrderId}")
	public Optional<CreateOrder> getById(@PathVariable("createOrderId") Long createOrderId)
	{
		return createOrderService.getById(createOrderId);
	}
	
	@DeleteMapping(value = "/delete/{createOrderId}")
	public void delete(@PathVariable("createOrderId") Long createOrderId)
	{
		createOrderService.delete(createOrderId);
	}
	
	@PutMapping(value = "/update/{createOrderId}")
	public CreateOrder update(@PathVariable("createOrderId") Long createOrderId,@RequestBody CreateOrder  createOrder)
	{
		return createOrderService.update(createOrderId, createOrder);
	}
}
