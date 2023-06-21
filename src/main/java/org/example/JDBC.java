package org.example;

import java.sql.*;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.Date;
import java.time.LocalDateTime;

public class JDBC {
    private static final String password = "G628N44v89";
    private static final String USER_NAME = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/finance_control";
    private Connection connection;

    public JDBC() {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void addToTable(String header) {
        PreparedStatement ps;
        Scanner scanner = new Scanner(System.in);
        //ResultSet rs;
        try {
            switch (header) {
                case "transactions":
                    ps = connection.prepareStatement("Insert into " + header + " (user_ID, category_ID, amount, date) values (?,?,?,?)");
                    //Date datetime = new Date();
                    printTable("user");
                    System.out.print("user_id ");
                    int user_id = scanner.nextInt();
                    ps.setInt(1, user_id);
                    printTable("categories");
                    System.out.print("category_id ");
                    int category_id = scanner.nextInt();
                    ps.setInt(2, category_id);
                    System.out.print("Amount ");
                    int am = scanner.nextInt();
                    ps.setInt(3, am);
                    ps.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
                    ps.executeUpdate();
                    break;
                case "user":
                    ps = connection.prepareStatement("Insert into " + header + " (username, email, password) values (?,?,?)");
                    System.out.print("Username ");
                    String usnm = scanner.nextLine();
                    System.out.print("Email ");
                    String email = scanner.nextLine();
                    System.out.print("Password ");
                    String passwrd = scanner.nextLine();
                    //Date datetime = new Date();
                    ps.setString(1, usnm);
                    ps.setString(2, email);
                    ps.setString(3, passwrd);
                    ps.executeUpdate();
                    break;
                case "categories":
                    ps = connection.prepareStatement("Insert into " + header + " (name, type) values (?,?)");
                    System.out.print("Name ");
                    String name = scanner.nextLine();
                    System.out.print("Type(1 - income, 2 - outcome) ");
                    int tmp = scanner.nextInt();
                    boolean type = tmp == 1 ? true : false;
                    ps.setString(1, name);
                    ps.setBoolean(2, type);
                    ps.executeUpdate();
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printTable(String header) {
        Statement statement;
        ResultSet rs;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("select * from " + header);
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.format("%40s", header);
            System.out.println();
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                System.out.format("%20s", rsmd.getColumnName(i + 1));
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    System.out.format("%20s", rs.getString(i + 1));
                }
                System.out.println();
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromTable(String header) {
        printTable(header);
        System.out.print("Choose row to delete by " + header + "_id ");
        Scanner scanner = new Scanner(System.in);
        String t_id = scanner.nextLine();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("delete from " + header + " where " + header + "_id = " + t_id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateInTable(String header) {
        printTable(header);
        System.out.print("Choose row to update by " + header + "_id ");
        Scanner scanner = new Scanner(System.in);
        String t_id = scanner.nextLine();
        PreparedStatement ps;
        try {
            switch (header) {
                case "transactions":
                    ps = connection.prepareStatement("update " + header + " set amount = ? where transaction_id = " + t_id);
                    System.out.print("Enter new amount ");
                    int am = scanner.nextInt();
                    //Date datetime = new Date();
                    ps.setInt(1, am);
                    ps.executeUpdate();
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
