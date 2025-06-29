package com.inventory.management.inventory_service;

import com.inventory.management.dao.InventoryDAO;
import com.inventory.management.entity.StockEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{
    // Let's call entity manager
    private InventoryDAO inventoryDAO;

    // Implementation class Constructor
    @Autowired
    public InventoryServiceImpl(InventoryDAO inventoryDAO){
        this.inventoryDAO = inventoryDAO;
    }

    @Override
    public boolean checkExist(int id) {
        return inventoryDAO.checkExist(id);
    }

    @Transactional
    @Override
    public void save(StockEntity stock) {
        if (inventoryDAO.checkExist(stock.getId())) {
            throw new IllegalArgumentException("Product with ID " + stock.getId() + " already exists.");

        } else {
            inventoryDAO.save(stock);
        }
    }

    @Override
    public StockEntity getByID(@RequestParam int id) {
        if(inventoryDAO.checkExist(id)) {
            return inventoryDAO.getByID(id);

        } else {
            throw new IllegalArgumentException("Product with ID " + id + " does not exist.");
        }
    }

    @Override
    public List<StockEntity> getAll() {
        return inventoryDAO.getAll();

    }

    @Transactional
    @Override
    public void delete(StockEntity stock) {
        if(inventoryDAO.checkExist(stock.getId())) {
            inventoryDAO.delete(stock);
        }else{
            throw new IllegalArgumentException("Product with ID " + stock.getId() + " does not exist.");
        }

    }

    @Transactional
    @Override
    public void update(StockEntity stock) {
        if(inventoryDAO.checkExist(stock.getId())) {
            inventoryDAO.update(stock);
        }else{
            throw new IllegalArgumentException("Product with ID " + stock.getId() + " does not exist.");
        }
    }

    @Override
    public List<StockEntity> getByProdName(String productName) {
        if(inventoryDAO.getByProdName(productName) != null) {
            return inventoryDAO.getByProdName(productName);
        }else {
            throw new IllegalArgumentException("Product with Name " + productName + " does not exist.");
        }
    }

}
