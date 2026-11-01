package com.hcl.ordercraft.service;

import com.hcl.ordercraft.model.PurchaseOrder;
import com.hcl.ordercraft.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    public PurchaseOrder getPurchaseOrderById(Long id) {
        return purchaseOrderRepository.findById(id).orElse(null);
    }

    public PurchaseOrder updatePurchaseOrder(
            Long id, PurchaseOrder purchaseOrder) {

        PurchaseOrder existingPurchaseOrder =
                purchaseOrderRepository.findById(id).orElse(null);

        if (existingPurchaseOrder != null) {
            existingPurchaseOrder.setOrderDate(
                    purchaseOrder.getOrderDate());
            existingPurchaseOrder.setStatus(
                    purchaseOrder.getStatus());
            existingPurchaseOrder.setTotalAmount(
                    purchaseOrder.getTotalAmount());
            existingPurchaseOrder.setSupplier(
                    purchaseOrder.getSupplier());

            return purchaseOrderRepository.save(existingPurchaseOrder);
        }

        return null;
    }

    public void deletePurchaseOrder(Long id) {
        purchaseOrderRepository.deleteById(id);
    }
}