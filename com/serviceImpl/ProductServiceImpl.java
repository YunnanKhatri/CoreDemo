package com.serviceImpl;

import com.model.Product;
import com.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    //List lai static nagarda jati ota obj banaim teti ota list banthyo so hamiley static banaunu parxa
    static List<Product> plist = new ArrayList<>();
    @Override
    public void addProduct(Product p) {

        plist.add(p);
        System.out.println("------added successfully----size: "+plist.size());
    }

    @Override
    public void deleteProduct(int index) {
        plist.remove(index);
    }

    @Override
    public List<Product> getAllProducts() {
        return plist;
    }
}
