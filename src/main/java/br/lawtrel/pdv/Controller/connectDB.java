package br.lawtrel.pdv.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class connectDB {

        private final String urlBanco = "jdbc:hsqldb:file:db/pdvdb";
        //private final String nomeBanco = "pdvdb";
        private final String userBanco = "sa";
        private final String senhaBanco = "";

        private Connection conexao;

        public void connect () throws SQLException {
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

        public Connection getConexao() throws SQLException {
                connect();
                return conexao;
        }
}
