package com.example.product.repository;


import com.example.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer> {
    @Query("select a from Product a where a.titleProduct = :titleProduct")
    Product findByTitleProduct(String titleProduct);
}
