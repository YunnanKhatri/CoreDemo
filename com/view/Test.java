package com.view;

import com.model.Product;
import com.service.ProductService;
import com.serviceImpl.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

//        addBtn();
        getAll();
//        deleteBtn();
//        //-------------show all products after deleted---------------
//        getAll();
    }

//    --------add product------------
    static void addBtn(){

        ProductService ps = new ProductServiceImpl();
//        Scanner sc = new Scanner(System.in);
//        char flag = 'y';
//        do{
//            Product p = new Product();
//            System.out.println("Enter Product Id: ");
//            p.setId(sc.nextInt());
//            System.out.println("Enter Product Name: ");
//            p.setName(sc.next());
//            System.out.println("Enter Price: ");
//            p.setPrice(sc.nextInt());
//            System.out.println("Enter Category: ");
//            p.setCategory(sc.next());
//
//            ps.addProduct(p);
//
//            System.out.println("Do you wanna add more product?[y/n]");
//            flag = sc.next().charAt(0);//read char from console
//        }while(flag == 'y');

            ps.addProduct();
    }
//    ---------------delete product--------------
        static void deleteBtn(){
            ProductService ps = new ProductServiceImpl();

            ps.deleteProduct();
        }
//------------get all products-------------
    static void getAll(){
        ProductService ps = new ProductServiceImpl();

        ps.getAllProducts();
//        System.out.println(plist);
    }
}
