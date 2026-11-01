package com.hcl.ordercraft.repository;

import com.hcl.ordercraft.model.SalesOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderItemRepository
        extends JpaRepository<SalesOrderItem, Long> {
}