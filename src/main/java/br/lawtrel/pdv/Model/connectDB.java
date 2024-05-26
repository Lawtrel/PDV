package br.lawtrel.pdv.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connectDB {

    private static final String urlBanco = "jdbc:hsqldb:file:db/pdvdb";
    private static final String userBanco = "SA";
    private static final String senhaBanco = "";
    private Connection connection;
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(urlBanco, userBanco, senhaBanco);

    }
}
