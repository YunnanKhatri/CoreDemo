package com.service;
//hamiley use garne class chai diff package ma xa vane import garnu parxa
import com.model.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product p);
    void deleteProduct(int index);
    List<Product> getAllProducts();

}
