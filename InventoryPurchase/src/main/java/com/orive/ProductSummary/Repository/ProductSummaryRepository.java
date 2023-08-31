package com.orive.ProductSummary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.ProductSummary.Entity.ProductSummaryDetails;

public interface ProductSummaryRepository extends JpaRepository<ProductSummaryDetails, Long>{

}
