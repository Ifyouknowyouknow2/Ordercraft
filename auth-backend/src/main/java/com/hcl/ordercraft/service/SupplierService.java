package com.hcl.ordercraft.service;

import com.hcl.ordercraft.model.Supplier;
import com.hcl.ordercraft.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public Supplier updateSupplier(Long id, Supplier supplier) {
        Supplier existingSupplier =
                supplierRepository.findById(id).orElse(null);

        if (existingSupplier != null) {
            existingSupplier.setName(supplier.getName());
            existingSupplier.setEmail(supplier.getEmail());
            existingSupplier.setPhone(supplier.getPhone());
            existingSupplier.setAddress(supplier.getAddress());

            return supplierRepository.save(existingSupplier);
        }

        return null;
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}