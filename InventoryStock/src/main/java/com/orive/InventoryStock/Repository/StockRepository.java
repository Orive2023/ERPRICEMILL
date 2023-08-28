package com.orive.InventoryStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.InventoryStock.Entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{

}
