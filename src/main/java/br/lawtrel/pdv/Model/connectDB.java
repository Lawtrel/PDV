package br.lawtrel.pdv.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connectDB {

    private static final String urlBanco = "jdbc:hsqldb:file:db/pdvdb";
    private static final String userBanco = "SA";
    private static final String senhaBanco = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(urlBanco, userBanco, senhaBanco);

    }
    public static void createTable() {
        try (Connection db = getConnection(); Statement stm = db.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXIST USERS ("
                    + "id INTEGER IDENTITY PRIMARY KEY. "
                    + "username VARCHAR(50) NOT NULL, "
                    + "password VARCHAR(50) NOT NULL"
                    + ")";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
