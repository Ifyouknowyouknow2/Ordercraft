package com.hcl.ordercraft.controller;

import com.hcl.ordercraft.model.BOMItem;
import com.hcl.ordercraft.service.BOMItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bom-items")
public class BOMItemController {

    private final BOMItemService bomItemService;

    public BOMItemController(BOMItemService bomItemService) {
        this.bomItemService = bomItemService;
    }

    @PostMapping
    public BOMItem createBOMItem(@RequestBody BOMItem bomItem) {
        return bomItemService.createBOMItem(bomItem);
    }

    @GetMapping
    public List<BOMItem> getAllBOMItems() {
        return bomItemService.getAllBOMItems();
    }

    @GetMapping("/{id}")
    public BOMItem getBOMItemById(@PathVariable Long id) {
        return bomItemService.getBOMItemById(id);
    }

    @PutMapping("/{id}")
    public BOMItem updateBOMItem(
            @PathVariable Long id,
            @RequestBody BOMItem bomItem) {
        return bomItemService.updateBOMItem(id, bomItem);
    }

    @DeleteMapping("/{id}")
    public String deleteBOMItem(@PathVariable Long id) {
        bomItemService.deleteBOMItem(id);
        return "BOM Item deleted successfully";
    }
}