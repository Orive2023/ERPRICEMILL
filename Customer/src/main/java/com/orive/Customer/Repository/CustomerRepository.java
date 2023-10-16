package com.orive.Customer.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orive.Customer.Entity.CustomerDetails;


public interface CustomerRepository extends JpaRepository<CustomerDetails, Long>{

	Optional<CustomerDetails> findByCustomerName(String customerName);
}
