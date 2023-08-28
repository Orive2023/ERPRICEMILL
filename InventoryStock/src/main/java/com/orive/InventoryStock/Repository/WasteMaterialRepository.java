package com.orive.InventoryStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.InventoryStock.Entity.WasteMaterial;

public interface WasteMaterialRepository extends JpaRepository<WasteMaterial, Long>{

}
