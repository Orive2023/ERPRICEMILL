package com.orive.InventorySales.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.InventorySales.Entity.CreateOrder;
import com.orive.InventorySales.Repository.CreateOrderRepository;


@Service
public class CreateOrderService {

	@Autowired
	private CreateOrderRepository createOrderRepository;
	
	public CreateOrder save(CreateOrder createOrder)
	{
		return createOrderRepository.save(createOrder);
	}
	
	public List<CreateOrder> getAll()
	{
		return createOrderRepository.findAll();
	}
	
	public Optional<CreateOrder> getById(Long createOrderId)
	{
		Optional<CreateOrder> optional=createOrderRepository.findById(createOrderId);
		if(optional.isPresent())
		{
			return optional;
		}
		else
		{
			throw new NoSuchElementException("OrderId not found");
		}
	}
	
	public void delete(Long createOrderId)
	{
		createOrderRepository.deleteById(createOrderId);
	}
	
	public CreateOrder update(Long createOrderId,CreateOrder  createOrder)
	{
		Optional<CreateOrder> optional=createOrderRepository.findById(createOrderId);
		if(optional.isPresent())
		{
			CreateOrder createOrder2=optional.get();
			createOrder2.setProducts(createOrder.getProducts());
			createOrder2.setQuantity(createOrder.getQuantity());
			createOrder2.setManufactoringDate(createOrder.getManufactoringDate());
			createOrder2.setQualityCheck(createOrder.getQualityCheck());
			createOrder2.setDistributor(createOrder.getDistributor());
			createOrder2.setEstimatedDeliveryDate(createOrder.getEstimatedDeliveryDate());
			createOrder2.setExpairyDate(createOrder.getExpairyDate());
			createOrder2.setOrderStatus(createOrder.getOrderStatus());
			createOrder2.setPricePerUnit(createOrder.getPricePerUnit());
			createOrder2.setUnit(createOrder.getUnit());
			
			CreateOrder createOrder3=createOrderRepository.save(createOrder2);
			return createOrder3;
	}else
	{
		throw new NoSuchElementException("Order Not Found");
	}
	
	}
}
