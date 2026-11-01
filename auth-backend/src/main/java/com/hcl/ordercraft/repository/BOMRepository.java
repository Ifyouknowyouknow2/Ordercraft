package com.hcl.ordercraft.repository;

import com.hcl.ordercraft.model.BOM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BOMRepository extends JpaRepository<BOM, Long> {
}