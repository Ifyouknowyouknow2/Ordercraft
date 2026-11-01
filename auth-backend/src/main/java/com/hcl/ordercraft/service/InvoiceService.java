package com.hcl.ordercraft.service;

import com.hcl.ordercraft.model.Invoice;
import com.hcl.ordercraft.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public Invoice updateInvoice(Long id, Invoice invoice) {
        Invoice existingInvoice =
                invoiceRepository.findById(id).orElse(null);

        if (existingInvoice != null) {
            existingInvoice.setInvoiceDate(invoice.getInvoiceDate());
            existingInvoice.setAmount(invoice.getAmount());
            existingInvoice.setStatus(invoice.getStatus());
            existingInvoice.setSalesOrder(invoice.getSalesOrder());

            return invoiceRepository.save(existingInvoice);
        }

        return null;
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}