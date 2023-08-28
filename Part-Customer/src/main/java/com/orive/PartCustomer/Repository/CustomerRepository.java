package com.orive.PartCustomer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.PartCustomer.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
