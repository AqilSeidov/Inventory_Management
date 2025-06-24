package com.inventory.management.controller;

import com.inventory.management.dao.InventoryDAO;
import com.inventory.management.entity.StockEntity;
import com.inventory.management.inventory_service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/add")
    public void add(@RequestBody StockEntity stock){
        inventoryService.save(stock);
    }

    @GetMapping("/get")
    public List<StockEntity> getAllItems(){
        return inventoryService.getAll();
    }

    @GetMapping("/get/{id}")
    public StockEntity getById(@PathVariable int id){
        StockEntity product = inventoryService.getByID(id);
        if (product == null){
            throw new RuntimeException("Product not found");
        }
        return product;
    }
}
