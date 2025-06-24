package com.inventory.management.controller;

import com.inventory.management.entity.StockEntity;
import com.inventory.management.inventory_service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
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

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody StockEntity stock){
        try{
            inventoryService.delete(stock);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody StockEntity stock){
        try {
            inventoryService.update(stock);
        }catch (IllegalArgumentException e){

            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        try{
            List<StockEntity> product = inventoryService.getByProdName(name);
            return ResponseEntity.ok().body(product);

        }catch(InvalidDataAccessApiUsageException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
