//package com.Controller;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DBController {
//    public void getProducts() {
//        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/platformdb", "postgres", "postgres")) {
//
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
//            String productsString = "";
//            while (resultSet.next()) {
//                productsString = productsString + resultSet.getInt("id") +
//                        resultSet.getString("name") +
//                        resultSet.getDouble("price")+
//                        resultSet.getString("breadcrumbs")+
//                        resultSet.getString("storeName") + "\n";
//            }
//
//        } /*catch (ClassNotFoundException e) {
//            System.out.println("PostgreSQL JDBC driver not found.");
//            e.printStackTrace();
//        }*/ catch (SQLException e) {
//            System.out.println("Connection failure.");
//            e.printStackTrace();
//        }
//    }
//}
