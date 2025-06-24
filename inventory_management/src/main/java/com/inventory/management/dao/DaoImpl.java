package com.inventory.management.dao;

import com.inventory.management.entity.StockEntity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements InventoryDAO{

    // Let's call entity manager
    public EntityManager entityManager;

    // Implementation class Constructor
    @Autowired
    public DaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(StockEntity stock){
        entityManager.persist(stock);
    }

    @Override
    public StockEntity getByID(int id) {
        StockEntity product = entityManager.find(StockEntity.class, id);
        return product;
    }

}
