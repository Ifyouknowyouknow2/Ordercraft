package com.hcl.ordercraft.service;

import com.hcl.ordercraft.model.BOM;
import com.hcl.ordercraft.repository.BOMRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BOMService {

    private final BOMRepository bomRepository;

    public BOMService(BOMRepository bomRepository) {
        this.bomRepository = bomRepository;
    }

    public BOM createBOM(BOM bom) {
        return bomRepository.save(bom);
    }

    public List<BOM> getAllBOMs() {
        return bomRepository.findAll();
    }

    public BOM getBOMById(Long id) {
        return bomRepository.findById(id).orElse(null);
    }

    public BOM updateBOM(Long id, BOM bom) {
        BOM existingBOM = bomRepository.findById(id).orElse(null);

        if (existingBOM != null) {
            existingBOM.setName(bom.getName());
            existingBOM.setVersion(bom.getVersion());
            existingBOM.setStatus(bom.getStatus());
            existingBOM.setProduct(bom.getProduct());

            return bomRepository.save(existingBOM);
        }

        return null;
    }

    public void deleteBOM(Long id) {
        bomRepository.deleteById(id);
    }
}