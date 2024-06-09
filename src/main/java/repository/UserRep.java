package repository;
import model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class UserRep implements Repository<User>{


        private Connection getConnection() throws SQLException {
        return DBConnection.getConnection();
    }

    private User createUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setLastname(resultSet.getString("lastname"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setBalance(resultSet.getDouble("balance"));
        return user;
    }

    public static void main(String[] args) {
        UserRep rep = new UserRep();
        User user = new User("Verónica", "Retamal", "vero@mail.com", "122", 0.0);
        try {
            rep.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(User user) throws SQLException {
        String sql = String.format("INSERT INTO user (name, lastname, email, password, balance) VALUES (?, ?, ?, ?, ?)",
                user.getName(), user.getLastname(), user.getEmail(), user.getPassword(), user.getBalance()); // Excluir ID

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setDouble(5, user.getBalance());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        @Override
    public List<User> read() throws SQLException {
        return null;
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}

