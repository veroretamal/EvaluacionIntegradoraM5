package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/operation")
    public class OperationServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            UserService service = new UserService();
            User user = (User) req.getSession().getAttribute("user");

            // Obtener el tipo de operación (Depósito o Retiro)
            String operation = req.getParameter("operation");

            // Obtener el monto de la operación
            double amount = Double.parseDouble(req.getParameter("monto"));

            try {
                if ("Depositar".equals(operation)) {
                    service.deposit(user, amount);
                } else if ("Retirar".equals(operation)) {
                    service.withdraw(user, amount);
                }
                // Actualizar el usuario en la sesión
                req.getSession().setAttribute("user", user);
                // Redireccionar de nuevo a la página principal después de la operación
                resp.sendRedirect("index.jsp");
            } catch (SQLException e) {
                // Manejar cualquier excepción SQL
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la operación");
            } catch (IllegalArgumentException e) {
                // Manejar saldo insuficiente para retiro
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            }
        }
    }