package service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dto.CompanyDto;

import java.io.IOException;
import java.util.List;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CompanyService companyService = CompanyService.getINSTANCE();
        List<CompanyDto> all = companyService.findAll();
        req.setAttribute("companies", all);
        req.getRequestDispatcher("/WEB-INF/content.jsp").forward(req,resp);
    }
}
