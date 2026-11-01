package com.hcl.ordercraft.controller;

import com.hcl.ordercraft.model.Material;
import com.hcl.ordercraft.service.MaterialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materials")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    // CREATE
    @PostMapping
    public Material createMaterial(@RequestBody Material material) {
        return materialService.createMaterial(material);
    }

    // GET ALL
    @GetMapping
    public List<Material> getAllMaterials() {
        return materialService.getAllMaterials();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Material getMaterialById(@PathVariable Long id) {
        return materialService.getMaterialById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Material updateMaterial(
            @PathVariable Long id,
            @RequestBody Material material) {

        return materialService.updateMaterial(id, material);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteMaterial(@PathVariable Long id) {
        materialService.deleteMaterial(id);
        return "Material deleted successfully";
    }
}