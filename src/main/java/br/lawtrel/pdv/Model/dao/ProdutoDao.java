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

            pst.setString(1,produto.getCodigo());
            pst.setString(2,produto.getDescricao());
            pst.setInt(3,produto.getQuantidade());
            pst.setDouble(4,produto.getPreco());

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

            pst.setString(1,produto.getCodigo());
            pst.setString(2,produto.getDescricao());
            pst.setInt(3,produto.getQuantidade());
            pst.setDouble(4,produto.getPreco());

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

            pst.setString(1,produto.getCodigo());

            pst.execute();
            return true;
        } catch (SQLException ex) {
          Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
          return  false;
        }
    }


    public Produto buscar(String codigo) {
        String sql = "SELECT * FROM produtos WHERE codigo = ?";
        Produto produto = null;
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,codigo);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                produto = new Produto();

                produto.setCodigo(rst.getString("codigo"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setQuantidade(rst.getInt("quantidade"));
                produto.setPreco(rst.getInt("preco"));
                return produto;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    public List<Produto> listarTodos() {
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rst.getString("codigo"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setQuantidade(rst.getInt("quantidade"));
                produto.setPreco(rst.getInt("preco"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

}
