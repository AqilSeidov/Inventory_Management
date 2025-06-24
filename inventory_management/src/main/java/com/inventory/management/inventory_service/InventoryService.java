package com.inventory.management.inventory_service;

import com.inventory.management.entity.StockEntity;

public interface InventoryService {

    void save(StockEntity stock);

    StockEntity getByID(int id);
}
