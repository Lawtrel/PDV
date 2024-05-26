package br.lawtrel.pdv.Model.dao;

import br.lawtrel.pdv.Model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    User getUser(String username, String password);
    List<User> getAllUsers();
}
