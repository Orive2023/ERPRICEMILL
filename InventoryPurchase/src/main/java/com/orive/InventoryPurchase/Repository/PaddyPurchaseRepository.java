package com.orive.InventoryPurchase.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.orive.InventoryPurchase.Entity.PaddyPurchase;


public interface PaddyPurchaseRepository extends JpaRepository<PaddyPurchase, Long>{

	@Query("SELECT p FROM PaddyPurchase p WHERE p.rstNumber = :rstNumber AND p.rstDetails = :rstDetails")
    Optional<PaddyPurchase> findByRstNumberAndRstDetails(
            @Param("rstNumber") String rstNumber,
            @Param("rstDetails") String rstDetails
    );
	
}
