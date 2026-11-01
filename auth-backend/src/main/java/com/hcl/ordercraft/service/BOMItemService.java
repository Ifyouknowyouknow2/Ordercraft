package com.hcl.ordercraft.service;

import com.hcl.ordercraft.model.BOMItem;
import com.hcl.ordercraft.repository.BOMItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BOMItemService {

    private final BOMItemRepository bomItemRepository;

    public BOMItemService(BOMItemRepository bomItemRepository) {
        this.bomItemRepository = bomItemRepository;
    }

    public BOMItem createBOMItem(BOMItem bomItem) {
        return bomItemRepository.save(bomItem);
    }

    public List<BOMItem> getAllBOMItems() {
        return bomItemRepository.findAll();
    }

    public BOMItem getBOMItemById(Long id) {
        return bomItemRepository.findById(id).orElse(null);
    }

    public BOMItem updateBOMItem(Long id, BOMItem bomItem) {
        BOMItem existingBOMItem =
                bomItemRepository.findById(id).orElse(null);

        if (existingBOMItem != null) {
            existingBOMItem.setQuantity(bomItem.getQuantity());
            existingBOMItem.setBom(bomItem.getBom());
            existingBOMItem.setMaterial(bomItem.getMaterial());

            return bomItemRepository.save(existingBOMItem);
        }

        return null;
    }

    public void deleteBOMItem(Long id) {
        bomItemRepository.deleteById(id);
    }
}