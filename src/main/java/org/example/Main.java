package org.example;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        JDBC daybi = new JDBC();
        int c = 1;
        String table;
        Scanner scanner = new Scanner(System.in);
        while(c != 0) {
            System.out.println("Menu");
            System.out.print("1 - add to table\n2 - show table\n3 - delete row from table\n4 - update raw in table\n0 - exit\n");
            c = scanner.nextInt();
            table = scanner.nextLine();
            switch(c){
                case 1:
                    System.out.print("Input header of table ");
                    table = scanner.nextLine();
                    //table = "transactions";
                    daybi.addToTable(table);
                    break;
                case 2:
                    System.out.print("Input header of table ");
                    table = scanner.nextLine();
                    daybi.printTable(table);
                    break;
                case 3:
                    System.out.print("Input header of table ");
                    table = scanner.nextLine();
                    daybi.deleteFromTable("user");
                    break;
                case 4:
                    System.out.print("Input header of table ");
                    table = scanner.nextLine();
                    daybi.updateInTable(table);
                    break;
                case 0:
                    break;
            }

        }
    }
}