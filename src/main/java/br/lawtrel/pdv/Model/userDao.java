package br.lawtrel.pdv.Model;

import java.util.List;

public interface userDao {
    public List<User> getAllUsers();
    public User getUser(int id);
    public void updateUser(User user);
    public void deleteUser(User user);
}
