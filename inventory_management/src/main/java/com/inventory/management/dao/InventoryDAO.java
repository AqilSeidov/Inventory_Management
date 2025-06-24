package com.inventory.management.dao;

import com.inventory.management.entity.StockEntity;

import java.util.List;

public interface InventoryDAO {

    void save(StockEntity stock);

    StockEntity getByID(int id);

    List<StockEntity> getAll();

    boolean checkExist(int id);

    void delete(StockEntity stock);

    void update(StockEntity stock);

}
