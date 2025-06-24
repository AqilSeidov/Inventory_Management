package com.inventory.management.controller;

import com.inventory.management.entity.StockEntity;
import com.inventory.management.inventory_service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> add(@RequestBody StockEntity stock){
        try{
            inventoryService.save(stock);
            return ResponseEntity.ok().build();
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public List<StockEntity> getAllItems(){
        return inventoryService.getAll();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){

        try{
            StockEntity product = inventoryService.getByID(id);
            return ResponseEntity.ok().body(product);

        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
