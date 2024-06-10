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
//Servlet para realizar el login
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    //Verificar la información entregada en el formulario de login
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserService service = new UserService();
        List<User> usuarios = service.getUsers();

        for (User user : usuarios) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login exitoso "+ user); //verificación del login en la consola
                req.getSession().setAttribute("user", user); // Almacenar usuario en sesión
                resp.sendRedirect("index.jsp"); // Redireccionar al usuario a su sesión
                return; // Salir del método doPost()
            }
        }

        // Respuesta ante el fallo del login
        resp.sendRedirect("login.jsp"); // Redireccionar al usuario al formulario de inicio de sesión
    }

}
