package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:C:/sqlite/db/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/baza.db";

        // SQL statement for creating a new table
        String grad = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id int PRIMARY KEY,\n"
                + "	naziv text NOT NULL,\n"
                + "	CONSTRAINT grad_drzava_glavni_grad_fk FOREIGN KEY (id) REFERENCES drzava (glavni_grad)\n"
                + ");";

        String drzava= "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id int PRIMARY KEY,\n"
                + "	naziv text NOT NULL,\n"
                + "	CONSTRAINT drzava_grad_broj_stanovnika_fk FOREIGN KEY (id) REFERENCES grad (broj_stanovnika)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             Statement stmt1 = conn.createStatement()) {
            // create a new table
            stmt.execute(grad);
            stmt1.execute(drzava);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewDatabase("baza");
        createNewTable();
        System.out.println("Gradovi su:\n" + ispisiGradove());
        glavniGrad();
    }

    private static void glavniGrad() {
    }

    public static String ispisiGradove() {
        String s="";
        return s;
    }

}
