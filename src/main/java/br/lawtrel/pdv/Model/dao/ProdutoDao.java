package br.lawtrel.pdv.Model.dao;

import br.lawtrel.pdv.Model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDao {
    private final Connection connection;
    public ProdutoDao(Connection connection) {
        this.connection = connection;
    }


    public boolean insert (Produto produto) {
        String sql = "INSERT INTO produtos(codigo,descricao, quantidade, preco) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,produto.getCodProduto());
            pst.setString(2,produto.getName());
            pst.setInt(3,produto.getQuantity());
            pst.setDouble(4,produto.getPrice());
            pst.execute();
            return  false;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }
    }

    public boolean alterar (Produto produto) {
        String sql = "UPDATE produtos SET codigo=?, descricao=?, quantidade=?, preco=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,produto.getCodProduto());
            pst.setString(2,produto.getName());
            pst.setInt(3,produto.getQuantity());
            pst.setDouble(4,produto.getPrice());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }
    }

    public boolean remove (Produto produto) {
        String sql = "DELETE FROM produtos WHERE codigo=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,produto.getCodProduto());
            pst.execute();
            return true;
        } catch (SQLException ex) {
          Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
          return  false;
        }
    }


    public Produto buscar(int codigo) {
        String sql = "SELECT * FROM produtos WHERE codigo = ?";
        Produto produto = null;
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,codigo);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                produto = new Produto();
                produto.setCodProduto(rst.getInt("codigo"));
                produto.setName(rst.getString("descricao"));
                produto.setPrice(rst.getInt("preco"));
                produto.setQuantity(rst.getInt("quantidade"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
}
