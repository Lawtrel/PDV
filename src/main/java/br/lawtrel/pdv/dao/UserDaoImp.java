package br.lawtrel.pdv.dao;

import br.lawtrel.pdv.Model.User;
import br.lawtrel.pdv.Model.connectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO USERS (username,password) VALUES(?,?)";
        try (Connection db = connectDB.getConnection();
             PreparedStatement pst = db.prepareStatement(sql)) {
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public User getUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement pst = connectDB.getConnection().prepareStatement(sql)) {
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                return new User(rst.getInt("id"), rst.getString("username"), rst.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM USERS";
        try (Connection db = connectDB.getConnection();
            Statement pst = db.createStatement();
            ResultSet rst = pst.executeQuery(sql)) {
            while (rst.next()) {
                users.add(new User(rst.getInt("id"), rst.getString("username"),rst.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
