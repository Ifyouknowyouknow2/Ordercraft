package com.hcl.ordercraft.repository;

import com.hcl.ordercraft.model.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
}