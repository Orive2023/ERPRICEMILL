package com.orive.InventoryStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.InventoryStock.Entity.RawMaterial;

public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long>{

}
