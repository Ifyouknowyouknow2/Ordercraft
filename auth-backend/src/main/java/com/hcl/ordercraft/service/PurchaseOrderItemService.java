package com.hcl.ordercraft.service;

import com.hcl.ordercraft.model.PurchaseOrderItem;
import com.hcl.ordercraft.repository.PurchaseOrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderItemService {

    private final PurchaseOrderItemRepository purchaseOrderItemRepository;

    public PurchaseOrderItemService(
            PurchaseOrderItemRepository purchaseOrderItemRepository) {
        this.purchaseOrderItemRepository = purchaseOrderItemRepository;
    }

    public PurchaseOrderItem createPurchaseOrderItem(
            PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderItemRepository.save(purchaseOrderItem);
    }

    public List<PurchaseOrderItem> getAllPurchaseOrderItems() {
        return purchaseOrderItemRepository.findAll();
    }

    public PurchaseOrderItem getPurchaseOrderItemById(Long id) {
        return purchaseOrderItemRepository.findById(id).orElse(null);
    }

    public PurchaseOrderItem updatePurchaseOrderItem(
            Long id, PurchaseOrderItem purchaseOrderItem) {

        PurchaseOrderItem existingPurchaseOrderItem =
                purchaseOrderItemRepository.findById(id).orElse(null);

        if (existingPurchaseOrderItem != null) {
            existingPurchaseOrderItem.setQuantity(
                    purchaseOrderItem.getQuantity());
            existingPurchaseOrderItem.setPrice(
                    purchaseOrderItem.getPrice());
            existingPurchaseOrderItem.setPurchaseOrder(
                    purchaseOrderItem.getPurchaseOrder());
            existingPurchaseOrderItem.setMaterial(
                    purchaseOrderItem.getMaterial());

            return purchaseOrderItemRepository.save(
                    existingPurchaseOrderItem);
        }

        return null;
    }

    public void deletePurchaseOrderItem(Long id) {
        purchaseOrderItemRepository.deleteById(id);
    }
}