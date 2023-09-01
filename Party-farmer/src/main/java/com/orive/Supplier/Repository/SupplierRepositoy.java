package com.orive.Supplier.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.orive.Supplier.Entity.SupplierDetails;

public interface SupplierRepositoy extends JpaRepository<SupplierDetails, Long>{

	 @Query("SELECT s FROM SupplierDetails s WHERE s.supplierName = :supplierName")
	    List<SupplierDetails> findBySupplierName(@Param("supplierName") String supplierName);
}
