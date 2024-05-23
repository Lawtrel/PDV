package br.lawtrel.pdv.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class connectDB {

        private static final String urlBanco = "jdbc:hsqldb:file:db/pdvdb";
        private static final String userBanco = "SA";
        private static final String senhaBanco = "";

        private static Connection conexao;

        public static void connect() throws SQLException {
           conexao = DriverManager.getConnection(urlBanco,userBanco,senhaBanco);
        }

        public void disconnect() throws SQLException {
            conexao.close();
        }

        public PreparedStatement executeScript(String sql) throws SQLException {

                System.out.println("Executando Script SQL " + sql);

                connect();
                PreparedStatement pstm = conexao.prepareStatement(sql);
                pstm.execute();
                conexao.commit();
                disconnect();
                return pstm;
        }

        public static Connection getConexao() throws SQLException {
                connect();
                return conexao;
        }
}
