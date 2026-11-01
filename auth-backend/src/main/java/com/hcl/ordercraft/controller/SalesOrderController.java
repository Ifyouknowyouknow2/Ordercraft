
package com.hcl.ordercraft.controller;

import com.hcl.ordercraft.model.SalesOrder;
import com.hcl.ordercraft.service.SalesOrderService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sales-orders")
@CrossOrigin(origins = "http://localhost:4200")
public class SalesOrderController {

    private final SalesOrderService salesOrderService;

    public SalesOrderController(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    @GetMapping
    public List<SalesOrder> getAllSalesOrders() {
        return salesOrderService.getAllSalesOrders();
    }

    @GetMapping("/{id}")
    public SalesOrder getSalesOrderById(@PathVariable Long id) {
        return salesOrderService.getSalesOrderById(id);
    }

    @PostMapping
    public SalesOrder createSalesOrder(@RequestBody SalesOrder salesOrder) {
        return salesOrderService.createSalesOrder(salesOrder);
    }

    @PutMapping("/{id}")
    public SalesOrder updateSalesOrder(
            @PathVariable Long id,
            @RequestBody SalesOrder salesOrder) {
        return salesOrderService.updateSalesOrder(id, salesOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteSalesOrder(@PathVariable Long id) {
        salesOrderService.deleteSalesOrder(id);
    }
}
