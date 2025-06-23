package com.inventory.management.inventory_service;

import com.inventory.management.dao.InventoryDAO;
import com.inventory.management.entity.StockEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService{
    // Let's call entity manager
    private InventoryDAO inventoryDAO;

    // Implementation class Constructor
    @Autowired
    public InventoryServiceImpl(InventoryDAO inventoryDAO){
        this.inventoryDAO = inventoryDAO;
    }

    @Transactional
    @Override
    public void save(StockEntity stock){
        inventoryDAO.save(stock);
    }

}
