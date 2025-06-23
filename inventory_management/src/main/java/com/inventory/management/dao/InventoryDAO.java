package com.inventory.management.dao;

import com.inventory.management.entity.StockEntity;

public interface InventoryDAO {
    void save(StockEntity stock);
}
