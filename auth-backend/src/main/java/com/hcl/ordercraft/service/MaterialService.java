package com.hcl.ordercraft.service;

import com.hcl.ordercraft.model.Material;
import com.hcl.ordercraft.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    // CREATE
    public Material createMaterial(Material material) {
        return materialRepository.save(material);
    }

    // GET ALL
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    // GET BY ID
    public Material getMaterialById(Long id) {
        return materialRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Material updateMaterial(Long id, Material material) {

        Material existingMaterial =
                materialRepository.findById(id).orElse(null);

        if (existingMaterial != null) {
            existingMaterial.setName(material.getName());
            existingMaterial.setDescription(material.getDescription());
            existingMaterial.setPrice(material.getPrice());
            existingMaterial.setStock(material.getStock());
            existingMaterial.setUnit(material.getUnit());

            return materialRepository.save(existingMaterial);
        }

        return null;
    }

    // DELETE
    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }
}