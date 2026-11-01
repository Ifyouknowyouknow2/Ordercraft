package com.hcl.ordercraft.service;

import com.hcl.ordercraft.model.Payment;
import com.hcl.ordercraft.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment updatePayment(Long id, Payment payment) {
        Payment existingPayment =
                paymentRepository.findById(id).orElse(null);

        if (existingPayment != null) {
            existingPayment.setPaymentDate(payment.getPaymentDate());
            existingPayment.setAmount(payment.getAmount());
            existingPayment.setPaymentMethod(payment.getPaymentMethod());
            existingPayment.setStatus(payment.getStatus());
            existingPayment.setInvoice(payment.getInvoice());

            return paymentRepository.save(existingPayment);
        }

        return null;
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}