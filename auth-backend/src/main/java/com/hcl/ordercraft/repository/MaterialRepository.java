package com.hcl.ordercraft.repository;

import com.hcl.ordercraft.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
