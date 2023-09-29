package com.serviceImpl;

import com.model.Product;
import com.service.ProductService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {
    //List lai static nagarda jati ota obj banaim teti ota list banthyo so hamiley static banaunu parxa
    static List<Product> plist = new ArrayList<>();
    @Override
    public void addProduct() {


        try {
            //1.register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.getConnection(url, un, pw)
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the total number of products you want to add: ");
            int size = sc.nextInt();

            for(int i=0; i<size; i++){

                System.out.println("Enter product details: ");
                System.out.println("Name: ");
                String name = sc.next();
                System.out.println("Company: ");
                String company = sc.next();
                System.out.println("Price: ");
                int price = sc.nextInt();
                System.out.println("Category: ");
                String category = sc.next();

                //write sql
                String sql = "insert into product(name, company, price, category) values(?,?,?,?)";
                //create prepared statement
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, company);
                preparedStatement.setInt(3, price);
                preparedStatement.setString(4, category);
                //execute prepared statement
                preparedStatement.executeUpdate();
                //close prepared statement
                preparedStatement.close();
                //close db

            }
            con.close();

            System.out.println("Added successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


//        plist.add(p);
//        System.out.println("------added successfully----size: "+plist.size());
    }

    @Override
    public void deleteProduct() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter total number of products you wanna delete: ");
            int size = sc.nextInt();

            for(int i=0; i<size; i++){
                System.out.println("Enter id of product that you wanna delete: ");
                int id = sc.nextInt();

                String sql = "delete from product where id=?";

                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, id);

                int rowsDeleted = preparedStatement.executeUpdate();

                if(rowsDeleted > 0){
                    System.out.println("Deleted successfully");
                }else{
                    System.out.println("Not found!");
                }

                preparedStatement.close();

            }

            con.close();


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }




//        plist.remove(index);
    }

    @Override
    public void getAllProducts() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
            String sql = "select * from product";

            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                System.out.println("Id: "+rs.getInt("id"));
                System.out.println("Name: "+rs.getString("name"));
                System.out.println("Company: "+rs.getString("company"));
                System.out.println("Price: "+rs.getInt("price"));
                System.out.println("Category: "+rs.getString("category"));
            }
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
