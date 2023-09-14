package com.orive.Supplier.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.orive.Supplier.Entity.SupplierDetails;

public interface SupplierRepositoy extends JpaRepository<SupplierDetails, Long>{

	Optional<SupplierDetails> findByBussinessOwnerName(String businessOwnerName);
}
