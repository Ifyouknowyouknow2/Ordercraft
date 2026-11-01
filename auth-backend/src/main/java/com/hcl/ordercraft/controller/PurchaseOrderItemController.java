package com.hcl.ordercraft.controller;

import com.hcl.ordercraft.model.PurchaseOrderItem;
import com.hcl.ordercraft.service.PurchaseOrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase-order-items")
public class PurchaseOrderItemController {

    private final PurchaseOrderItemService purchaseOrderItemService;

    public PurchaseOrderItemController(
            PurchaseOrderItemService purchaseOrderItemService) {
        this.purchaseOrderItemService = purchaseOrderItemService;
    }

    @PostMapping
    public PurchaseOrderItem createPurchaseOrderItem(
            @RequestBody PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderItemService
                .createPurchaseOrderItem(purchaseOrderItem);
    }

    @GetMapping
    public List<PurchaseOrderItem> getAllPurchaseOrderItems() {
        return purchaseOrderItemService.getAllPurchaseOrderItems();
    }

    @GetMapping("/{id}")
    public PurchaseOrderItem getPurchaseOrderItemById(
            @PathVariable Long id) {
        return purchaseOrderItemService
                .getPurchaseOrderItemById(id);
    }

    @PutMapping("/{id}")
    public PurchaseOrderItem updatePurchaseOrderItem(
            @PathVariable Long id,
            @RequestBody PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderItemService
                .updatePurchaseOrderItem(id, purchaseOrderItem);
    }

    @DeleteMapping("/{id}")
    public String deletePurchaseOrderItem(@PathVariable Long id) {
        purchaseOrderItemService.deletePurchaseOrderItem(id);
        return "Purchase Order Item deleted successfully";
    }
}