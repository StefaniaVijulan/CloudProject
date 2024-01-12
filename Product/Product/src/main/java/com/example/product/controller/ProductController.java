package com.example.product.controller;


import com.example.product.dto.product.ProductRequest;
import com.example.product.dto.product.ProductResponse;
import com.example.product.model.Product;
import com.example.product.service.product.ProductServiceInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")

public class ProductController {

    private final ProductServiceInt productServiceInt;

    public ProductController(ProductServiceInt productServiceInt) {
        this.productServiceInt = productServiceInt;
    }


    @PostMapping
    public ProductResponse addProduct(@RequestBody ProductRequest product, @RequestParam Integer idCategory) throws Exception {
        return productServiceInt.addProduct(product, idCategory);
    }
    @PutMapping
    public ProductResponse editProduct(@RequestBody ProductRequest product){
        return productServiceInt.editProduct(product);
    }
    @DeleteMapping
    public String deleteProduct(@RequestParam Integer idProduct) {
        return productServiceInt.deleteProduct(idProduct);
    }
    @GetMapping
    public List<Product> listOfProducts() throws Exception {
        System.out.println("ccee");
        return productServiceInt.getAllProduct();
    }

}
