package service;

import model.User;
import repository.UserRep;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserRep repository = new UserRep();
        public List<User> getUsers() {
        try {
            return repository.read();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Lógica para depositar en la base de datos
    // Actualizar el balance del usuario
        public void deposit(User user, double amount) throws SQLException {

            double newBalance = user.getBalance() + amount;
            user.setBalance(newBalance);
            repository.update(user);
        }
    // Lógica para retirar de la base de datos
    // Verificar si el usuario tiene suficiente saldo
        public void withdraw(User user, double amount) throws SQLException {

            if (user.getBalance() >= amount) {
                // Actualizar el balance del usuario
                double newBalance = user.getBalance() - amount;
                user.setBalance(newBalance);
                repository.update(user);
            } else {
                throw new IllegalArgumentException("Saldo insuficiente para realizar el retiro");
            }
        }
    }

