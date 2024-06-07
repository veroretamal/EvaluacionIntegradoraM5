package service;

import model.User;
import repository.UserRep;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserRep repository = new UserRep();

    public void registration(User user) {
        try {
            repository.create(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getUsers() {
        try {
            return repository.read();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}