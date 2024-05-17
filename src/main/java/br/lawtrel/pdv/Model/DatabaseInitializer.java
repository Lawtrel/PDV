package br.lawtrel.pdv.Model;

import br.lawtrel.pdv.Model.connectDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {
        connectDB dbConnection = new connectDB();
        try (Connection connection = dbConnection.getConexao();
             Statement stmt = connection.createStatement()) {
            String script = readScript("src/main/resources/br/lawtrel/pdv/assets/initdb.sql");
            for (String sql : script.split(";")) {
                if (!sql.trim().isEmpty()) {
                    stmt.execute(sql);
                }
            }
            connection.commit();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static String readScript(String filePath) throws IOException {
        StringBuilder script = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                script.append(line).append("\n");
            }
        }
        return script.toString();
    }

    public static void main(String[] args) {
        initialize();
    }
}
