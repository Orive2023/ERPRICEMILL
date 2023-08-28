package com.orive.InventoryStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.InventoryStock.Entity.FinishedMaterial;

public interface FinishedMaterialRepository extends JpaRepository<FinishedMaterial, Long>{

}
