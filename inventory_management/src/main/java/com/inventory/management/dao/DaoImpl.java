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

    StockEntity stockEntity = new StockEntity();

    @Override
    public boolean checkExist(int id) {
        boolean item = entityManager.find(StockEntity.class , id) !=null;
        if(item){
            return false;
        }
        return true;
    }

    @Override
    public void save(StockEntity stock){
        if(checkExist(stock.getId())){
            entityManager.persist(stock);
        }
        else{
            throw new IllegalArgumentException("Product with ID " + stock.getId() + " already exists.");
        }

    }

    @Override
    public StockEntity getByID(int id) {
        if(checkExist(id)){
            throw new IllegalArgumentException("Product with ID " + id + " does not exist.");

        }else{
            return entityManager.find(StockEntity.class , id);
        }

    }

    @Override
    public List<StockEntity> getAll() {

        TypedQuery<StockEntity> theQuery  = entityManager.createQuery("FROM StockEntity", StockEntity.class);

        List<StockEntity> all_inventory = theQuery.getResultList();

        return all_inventory;
    }


}
