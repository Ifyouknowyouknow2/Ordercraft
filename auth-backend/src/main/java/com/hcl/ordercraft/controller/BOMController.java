package com.hcl.ordercraft.controller;

import com.hcl.ordercraft.model.BOM;
import com.hcl.ordercraft.service.BOMService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boms")
public class BOMController {

    private final BOMService bomService;

    public BOMController(BOMService bomService) {
        this.bomService = bomService;
    }

    @PostMapping
    public BOM createBOM(@RequestBody BOM bom) {
        return bomService.createBOM(bom);
    }

    @GetMapping
    public List<BOM> getAllBOMs() {
        return bomService.getAllBOMs();
    }

    @GetMapping("/{id}")
    public BOM getBOMById(@PathVariable Long id) {
        return bomService.getBOMById(id);
    }

    @PutMapping("/{id}")
    public BOM updateBOM(
            @PathVariable Long id,
            @RequestBody BOM bom) {
        return bomService.updateBOM(id, bom);
    }

    @DeleteMapping("/{id}")
    public String deleteBOM(@PathVariable Long id) {
        bomService.deleteBOM(id);
        return "BOM deleted successfully";
    }
}