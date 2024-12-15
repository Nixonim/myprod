package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsersService;

import java.io.IOException;
import java.util.Optional;

@MultipartConfig(fileSizeThreshold = 1024 * 1024)
@WebServlet("/login")
public class loginServlet extends HttpServlet {

    UsersService usersService = UsersService.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("email") + " " + req.getParameter("password"));
        usersService.findByUsersAuth(req.getParameter("email"),req.getParameter("password")).ifPresentOrElse(
                user -> {
                    req.getSession().setAttribute("user", user);
                    resp.addCookie(new Cookie("name", user.getName()));
                    try {
                        resp.sendRedirect("/companies");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }, () -> {
                    try {
                        resp.sendRedirect("/registration");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

    }
}
