package com.hcl.ordercraft.repository;

import com.hcl.ordercraft.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}