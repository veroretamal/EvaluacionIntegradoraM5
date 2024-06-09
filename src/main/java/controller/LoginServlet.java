package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserService service = new UserService();
        List<User> usuarios = service.getUsers();

        for (User user : usuarios) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login exitoso!!! " + user);
                req.getSession().setAttribute("user", user); // Almacenar usuario en sesión
                resp.sendRedirect("index.jsp"); // Redireccionar al usuario a la página de inicio
                return; // Salir del método doPost()
            }
        }

        // Si llegamos aquí, el inicio de sesión falló
        resp.sendRedirect("login.jsp"); // Redireccionar al usuario de nuevo al formulario de inicio de sesión
    }

}
