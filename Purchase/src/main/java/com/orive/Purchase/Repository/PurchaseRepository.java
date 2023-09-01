package com.orive.Purchase.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Purchase.Entity.PurchaseDetails;

public interface PurchaseRepository extends JpaRepository<PurchaseDetails, Long>{

}
