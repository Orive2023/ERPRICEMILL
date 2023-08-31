package com.orive.Supplier.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.orive.Supplier.Entity.SupplierDetails;

public interface SupplierRepositoy extends JpaRepository<SupplierDetails, Long>{

}
