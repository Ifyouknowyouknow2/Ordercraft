package com.hcl.ordercraft.repository;

import com.hcl.ordercraft.model.BOMItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BOMItemRepository extends JpaRepository<BOMItem, Long> {
}