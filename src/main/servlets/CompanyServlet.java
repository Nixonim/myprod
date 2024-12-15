package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dto.CompanyDto;
import service.CompanyService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/companies")
public class CompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CompanyService companyService = CompanyService.getINSTANCE();
        List<CompanyDto> all = companyService.findAll();
        req.setAttribute("companies", all);
        req.getRequestDispatcher("WEB-INF/company.jsp").forward(req,resp);
    }
}
