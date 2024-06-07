package repository;
import repository.Repository;
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
        user.setName(resultSet.getString("nombre"));
        user.setLastname(resultSet.getString("apellido"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setBalance(resultSet.getDouble("balance"));
        return user;

    }

    public static void main(String[] args) {
        UserRep rep = new UserRep();
        User user = new User(1, "vero", "retamal", "vero@mail.com", "122");
        try {
            rep.create(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(User user) throws SQLException {
        String sql = String.format("INSERT INTO user (id, nombre, apellido, email, password, balance)" + "VALUES ('%d', '%s', '%s','%s', '%s', '%s')"
                , user.getId(), user.getName(), user.getLastname(), user.getEmail(), user.getPassword(), user.getBalance());

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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

