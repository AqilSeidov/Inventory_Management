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
        boolean item = entityManager.find(StockEntity.class , id) != null;
        if(item == true){
            return true;
        }
        return false;
    }

    @Override
    public void save(StockEntity stock){
        if(checkExist(stock.getId())){
            throw new IllegalArgumentException("Product with ID " + stock.getId() + " already exists.");
        }
        else{
            entityManager.persist(stock);
        }

    }

    @Override
    public StockEntity getByID(int id) {
        if(checkExist(id)){
            return entityManager.find(StockEntity.class , id);

        }else{
            throw new IllegalArgumentException("Product with ID " + id + " does not exist.");
        }

    }

    @Override
    public List<StockEntity> getAll() {

        TypedQuery<StockEntity> theQuery  = entityManager.createQuery("FROM StockEntity", StockEntity.class);

        List<StockEntity> all_inventory = theQuery.getResultList();

        return all_inventory;
    }


    @Override
    public void delete(StockEntity stock) {
        int id = stock.getId();

        if(checkExist(id)){
            entityManager.remove(entityManager.find(StockEntity.class , id));

        }else{
            throw new IllegalArgumentException("Product with ID " + id + " does not exist.");

        }
    }

    @Override
    public void update(StockEntity stock) {
        if(checkExist(stock.getId())){
            entityManager.merge(stock);
        }
        else{
            throw new IllegalArgumentException("Product with ID " + stock.getId() + " does not exist.");
        }
    }

    @Override
    public List<StockEntity> getByProdName(String productName) {

        TypedQuery<StockEntity> theQuery = entityManager.createQuery(
                "FROM StockEntity s WHERE s.product LIKE :productName", StockEntity.class);
        theQuery.setParameter("productName", productName);

        List<StockEntity> result = theQuery.getResultList();

        if (result.isEmpty()) {
            throw new IllegalArgumentException("Product with Name " + productName + " does not exist.");
        }

        return result;
    }


}
