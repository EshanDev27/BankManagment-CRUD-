package org.example;

import java.sql.*;
import java.util.Scanner;

public class operation {
    public static String URL = "jdbc:mysql://localhost:3306/bank";
    public static String username = "root";
    public static String password = "admin";
    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    int acc_no, balance;
    String name;
    Scanner sc = new Scanner(System.in);
    static {
        try {
            connection = DriverManager.getConnection(URL, username, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void new_acc() throws SQLException {
        System.out.println("Enter your Name");
        name = sc.nextLine();
        System.out.println("Enter your Account Balance");
        balance = sc.nextInt();
        String query = "INSERT INTO account(name, balance) values(?, ?);";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, balance);

        preparedStatement.executeUpdate();
        System.out.println("*********Data has been Inserted**************");
    }

    public void check_bal(int accNo) throws SQLException {
        String query = "select balance from account where acc_no = ?;";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, accNo);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println("For Account no. " + accNo + " the balance is " + resultSet.getInt(1));
        }
    }

    public void withdraw(int accNo) throws SQLException {
        System.out.println("Enter the amount you want to withdraw");
        int withdraw_amt = sc.nextInt();
        String query = "Update account SET balance = balance - " + withdraw_amt + " WHERE acc_no = " + accNo + ";";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        System.out.println("************Money has been withdrawn***********");
    }

    public void deposit(int accNo) throws SQLException {
        System.out.println("Enter amount you want to deposit");
        int deposit_amt = sc.nextInt();
        String query = "UPDATE account SET balance = balance + " + deposit_amt + " WHERE acc_no = " + accNo + ";";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        System.out.println("***********Money has been deposited**********");
    }

    public void delete_acc(int accNo) throws SQLException {
        String query = "DELETE FROM account WHERE acc_no = " + accNo +";";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        System.out.println("Account has been successfully Deleted");
    }
}