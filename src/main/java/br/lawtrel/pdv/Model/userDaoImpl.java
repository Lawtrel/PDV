package br.lawtrel.pdv.Model;

import br.lawtrel.pdv.Model.connectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userDaoImpl implements userDao {
    private Connection conexao;
   public userDaoImpl() throws SQLException {
       conexao = connectDB.getConexao();
   }

    @Override
    public List<User> getAllUsers() {

       try {
           Statement statement = conexao.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
           while (resultSet.next()) {
               User user = new User();
               user.setId(resultSet.getInt("id"));
               user.setUsername(resultSet.getString("name"));
               user.setPassword(resultSet.getString("password"));
               user.add(user);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return users;
    }

    @Override
    public User getUser(int id) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM users WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
       try {
           PreparedStatement pstm = conexao.prepareStatement("UPDATE users SET name=?, password=? WHERE id=?");
           pstm.setString(1,user.getUsername());
           pstm.setString(2,user.getPassword());
           pstm.setInt(3,user.getId());


       } catch (SQLException e) {
           e.printStackTrace();
       }

    }

    @Override
    public void deleteUser(User user) {
       try {
           PreparedStatement pstm = conexao.prepareStatement("DELETE FROM users WHERE id=?");
           pstm.setInt(1,user.getId());
           pstm.executeUpdate();
       }catch (SQLException e){
           e.printStackTrace();
       }

    }
}
