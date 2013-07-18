/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.ums.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection = null;

    static {
        initConnection();
    }

    private static void initConnection() {
        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver class not found");
            e.printStackTrace();
        }

        System.out.println("MySQL JDBC Driver Registered!");

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/ums", "root", "root");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection == null) {
            System.out.println("Failed to make connection!");
        }
    }

    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            initConnection();
        }
        return connection;
    }
}