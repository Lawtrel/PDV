package br.lawtrel.pdv.Model.dao;

import br.lawtrel.pdv.Model.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDao {
    private final Connection connection;

    public VendaDao(Connection connection) {
        this.connection = connection;
    }

    public void insert(Venda venda) {

        String sql = "INSERT INTO VENDAS(data,valor,pago, forma_pagamento) VALUES(?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setDate(1, Date.valueOf(venda.getData()));
            pst.setDouble(2, venda.getValor());
            pst.setBoolean(3, venda.getPago());
            pst.setString(4, venda.getFormaDePagamento());
            pst.executeUpdate();

            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                venda.setCodVenda(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Falha ao gerar o ID da venda");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Venda venda) {
        String sql = "DELETE FROM VENDAS WHERE codigo=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, venda.getCodVenda());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Venda> listar() {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM VENDAS";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Venda venda = new Venda();
                venda.setCodVenda(rst.getInt("id"));
                venda.setData(rst.getDate("data").toLocalDate());
                venda.setValor(rst.getDouble("valor"));
                venda.setPago(rst.getBoolean("pago"));
                venda.setFormaDePagamento(rst.getString("forma_pagamento"));

                //venda.setItensdeVenda(carregarItensVenda(venda.getCodVenda()));

                vendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }

    public double calcularTotalVendas() {
        String sql = "SELECT SUM(valor) AS total FROM VENDAS";
        double total = 0;
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                total = rst.getDouble("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
}
