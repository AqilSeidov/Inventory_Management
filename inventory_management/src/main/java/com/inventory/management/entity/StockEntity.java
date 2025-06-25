package com.inventory.management.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "management")
public class StockEntity {

    //---------------COLUMNS--------------------------------
    @Id
    @Column(name = "id",nullable = false,unique=true)
    private int id;

    @Column(name = "product", nullable = false)
    private String product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name="category", nullable = false)
    private String category;

//-----------------------------------------------------------

    // Default Constructor

    public StockEntity() {}

    //Constructor
    public StockEntity(int id, String product, int quantity, double price, String category) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }



    // Getters and  Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}