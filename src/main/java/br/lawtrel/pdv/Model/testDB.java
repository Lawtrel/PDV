package br.lawtrel.pdv.Model;

import br.lawtrel.pdv.Model.connectDB;

import java.sql.SQLException;

public class testDB {
    public  static void main(String[] args) throws SQLException {
        connectDB conexao = new connectDB();

        conexao.connect();
        System.out.println("Conexao realizada com sucesso!");
        conexao.disconnect();
        System.out.println("Conexao fechada com sucesso!");
    }
}