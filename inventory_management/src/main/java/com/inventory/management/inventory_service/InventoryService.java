package com.inventory.management.inventory_service;

import com.inventory.management.entity.StockEntity;

import java.util.List;

public interface InventoryService {

    void save(StockEntity stock);

    StockEntity getByID(int id);

    List<StockEntity> getAll();

    boolean checkExist(int id);

    void delete(int id);
}
