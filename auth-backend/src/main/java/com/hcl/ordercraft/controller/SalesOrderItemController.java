package com.hcl.ordercraft.controller;

import com.hcl.ordercraft.model.SalesOrderItem;
import com.hcl.ordercraft.service.SalesOrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales-order-items")
public class SalesOrderItemController {

    private final SalesOrderItemService salesOrderItemService;

    public SalesOrderItemController(
            SalesOrderItemService salesOrderItemService) {
        this.salesOrderItemService = salesOrderItemService;
    }

    @PostMapping
    public SalesOrderItem createSalesOrderItem(
            @RequestBody SalesOrderItem salesOrderItem) {
        return salesOrderItemService.createSalesOrderItem(salesOrderItem);
    }

    @GetMapping
    public List<SalesOrderItem> getAllSalesOrderItems() {
        return salesOrderItemService.getAllSalesOrderItems();
    }

    @GetMapping("/{id}")
    public SalesOrderItem getSalesOrderItemById(
            @PathVariable Long id) {
        return salesOrderItemService.getSalesOrderItemById(id);
    }

    @PutMapping("/{id}")
    public SalesOrderItem updateSalesOrderItem(
            @PathVariable Long id,
            @RequestBody SalesOrderItem salesOrderItem) {
        return salesOrderItemService.updateSalesOrderItem(id, salesOrderItem);
    }

    @DeleteMapping("/{id}")
    public String deleteSalesOrderItem(@PathVariable Long id) {
        salesOrderItemService.deleteSalesOrderItem(id);
        return "Sales Order Item deleted successfully";
    }
}