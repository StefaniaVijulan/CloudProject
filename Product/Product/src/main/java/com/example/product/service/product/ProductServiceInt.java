package com.example.product.service.product;

import com.example.product.dto.product.ProductRequest;
import com.example.product.dto.product.ProductResponse;
import com.example.product.model.Product;

import java.util.List;

public interface ProductServiceInt {
    public ProductResponse addProduct(ProductRequest product, Integer idCategory);

    public ProductResponse editProduct(ProductRequest product);

    public String deleteProduct(Integer idProduct);

    public List<Product> getAllProduct();

}