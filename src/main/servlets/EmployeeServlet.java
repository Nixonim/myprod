package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EmployeeService;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        int companyId = Integer.parseInt(req.getParameter("companyId"));
        EmployeeService instance = EmployeeService.getINSTANCE();

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1> Список сотрудников компании ");
            writer.write("<ul>");
            instance.findEmpInCompany(companyId).forEach(employeeDto -> writer.write("""
                    <li>
                    %S  ----- %S ------- %S
                    
                    </li>
                    """.formatted(employeeDto.getId(),employeeDto.getName(),employeeDto.getStatus())));

            writer.write("</ul>");
        }

    }
}
