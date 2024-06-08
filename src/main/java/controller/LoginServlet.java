package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Conexion exitosa a LoginServlet con do get");
//        String name = req.getParameter("nombre");
//        String password = req.getParameter("password");
//        UserService service = new UserService();
//        List<User> users = service.getUsers();
//        for(User user: users) {
//            if(user.getName().equals(name)) {
//                if(user.getPassword().equals(password)) {
//                    System.out.println("Login exitoso!!! " + user);
//                    req.setAttribute("usuario", user);
//                    getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
//                }
//            }
//        }
//    }
    }
}
