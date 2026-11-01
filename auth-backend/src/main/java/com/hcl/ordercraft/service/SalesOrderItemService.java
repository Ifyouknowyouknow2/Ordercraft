package com.hcl.ordercraft.service;

import com.hcl.ordercraft.model.SalesOrderItem;
import com.hcl.ordercraft.repository.SalesOrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderItemService {

    private final SalesOrderItemRepository salesOrderItemRepository;

    public SalesOrderItemService(
            SalesOrderItemRepository salesOrderItemRepository) {
        this.salesOrderItemRepository = salesOrderItemRepository;
    }

    public SalesOrderItem createSalesOrderItem(SalesOrderItem salesOrderItem) {
        return salesOrderItemRepository.save(salesOrderItem);
    }

    public List<SalesOrderItem> getAllSalesOrderItems() {
        return salesOrderItemRepository.findAll();
    }

    public SalesOrderItem getSalesOrderItemById(Long id) {
        return salesOrderItemRepository.findById(id).orElse(null);
    }

    public SalesOrderItem updateSalesOrderItem(
            Long id, SalesOrderItem salesOrderItem) {

        SalesOrderItem existingSalesOrderItem =
                salesOrderItemRepository.findById(id).orElse(null);

        if (existingSalesOrderItem != null) {
            existingSalesOrderItem.setQuantity(
                    salesOrderItem.getQuantity());
            existingSalesOrderItem.setPrice(
                    salesOrderItem.getPrice());
            existingSalesOrderItem.setSalesOrder(
                    salesOrderItem.getSalesOrder());
            existingSalesOrderItem.setProduct(
                    salesOrderItem.getProduct());

            return salesOrderItemRepository.save(existingSalesOrderItem);
        }

        return null;
    }

    public void deleteSalesOrderItem(Long id) {
        salesOrderItemRepository.deleteById(id);
    }
}