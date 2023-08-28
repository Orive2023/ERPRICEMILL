package com.orive.InventorySales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.InventorySales.Entity.CreateOrder;

public interface CreateOrderRepository extends JpaRepository<CreateOrder, Long>{

}
