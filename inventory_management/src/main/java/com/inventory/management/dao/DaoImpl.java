package com.inventory.management.dao;

import com.inventory.management.entity.StockEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

        if(product == null){
            throw new RuntimeException("Stock not found");
        }
        return product;
    }

    @Override
    public List<StockEntity> getAll() {

        TypedQuery<StockEntity> theQuery  = entityManager.createQuery("FROM StockEntity", StockEntity.class);

        List<StockEntity> all_inventory = theQuery.getResultList();

        return all_inventory;
    }

}
