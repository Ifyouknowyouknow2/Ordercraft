package com.hcl.ordercraft.repository;

import com.hcl.ordercraft.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}