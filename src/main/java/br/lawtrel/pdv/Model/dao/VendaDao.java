package br.lawtrel.pdv.Model.dao;
import br.lawtrel.pdv.Model.Produto;
import br.lawtrel.pdv.Model.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDao {

    //Connection db = connectDB.getConnection();
    private final Connection connection;

    public VendaDao(Connection connection) {
        this.connection = connection;
    }

    /*public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }*/
    public void insert(Venda venda) {
        String sql = "INSERT INTO VENDAS(data,valor,pago) VALUES(?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setDate(1, Date.valueOf(venda.getData()));
            pst.setDouble(2,venda.getValor());
            pst.setBoolean(3,venda.getPago());
            //pst.setInt(4,venda.getCliente().getCodCliente());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Venda venda) {
        String sql = "DELETE FROM VENDAS WHERE codigo=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,venda.getCodVenda());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List <Venda> listar() {
        String sql = "SELECT * FROM VENDAS";
        List<Venda> Return = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Venda venda = new Venda();
                //Cliente cliente = new Cliente();
                List<Produto> itemdeVenda = new ArrayList();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Return;
    }


}
