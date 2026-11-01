package com.hcl.ordercraft.repository;

import com.hcl.ordercraft.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}