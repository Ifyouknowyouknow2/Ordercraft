package com.hcl.ordercraft.repository;

import com.hcl.ordercraft.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
