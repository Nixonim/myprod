package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dto.UsersDto;
import service.UsersService;
import validator.ValidationExeption;


import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024)
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    UsersService usersService = UsersService.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersDto usersDto = UsersDto.builder().name(req.getParameter("name")).birthday(req.getParameter("birthday"))
                .email(req.getParameter("email")).password(req.getParameter("password")).image(req.getPart("image"))
                .gender(req.getParameter("genders")).role(req.getParameter("roles"))
                .build();
        try {
            Integer i = usersService.create(usersDto);
            System.out.println("номер созданного айди - " + i);
        } catch (ValidationExeption validationExeption) {
            req.setAttribute("errors", validationExeption.getErrors());
            doGet(req,resp);
        }

    }
}
