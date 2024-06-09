package repository;
import model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    public void create(User user) throws SQLException {
        String sql = String.format("INSERT INTO user (name, lastname, email, password, balance) VALUES (?, ?, ?, ?, ?)");

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
            List<User> users = new ArrayList<>();
            String sql = "SELECT * FROM user";

            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    users.add(createUser(resultSet));
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Maneja o lanza la excepción según corresponda
            }

            return users;

        }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}

