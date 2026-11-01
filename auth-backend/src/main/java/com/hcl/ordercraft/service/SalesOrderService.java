
package com.hcl.ordercraft.service;

import com.hcl.ordercraft.model.SalesOrder;
import com.hcl.ordercraft.repository.SalesOrderRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalesOrderService {

    private final SalesOrderRepository salesOrderRepository;

    public SalesOrderService(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }

    public List<SalesOrder> getAllSalesOrders() {
        return salesOrderRepository.findAll();
    }

    public SalesOrder getSalesOrderById(Long id) {
        return salesOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    public SalesOrder createSalesOrder(SalesOrder salesOrder) {
        return salesOrderRepository.save(salesOrder);
    }

    public SalesOrder updateSalesOrder(Long id, SalesOrder updatedOrder) {
        SalesOrder existingOrder = getSalesOrderById(id);

        existingOrder.setOrderDate(updatedOrder.getOrderDate());
        existingOrder.setStatus(updatedOrder.getStatus());
        existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
        existingOrder.setCustomer(updatedOrder.getCustomer());

        return salesOrderRepository.save(existingOrder);
    }

    public void deleteSalesOrder(Long id) {
        SalesOrder existingOrder = getSalesOrderById(id);
        salesOrderRepository.delete(existingOrder);
    }
}
