package com.orive.Supplier.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.orive.Supplier.Entity.CustomerDetails;

public interface SupplierRepositoy extends JpaRepository<CustomerDetails, Long>{

	Optional<CustomerDetails> findByBussinessOwnerName(String businessOwnerName);
}
