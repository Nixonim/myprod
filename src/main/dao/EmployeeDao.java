package dao;

import entity.Employee;
import util.ConnectionGate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDao implements Dao<Integer, Employee> {

    private static EmployeeDao INSTANCE = new EmployeeDao();

    private String findEmpCompId = """
            select *
            from employee
            where companyid = ?;
            """;

    public EmployeeDao() {
    }

    public static EmployeeDao getINSTANCE() {
        return INSTANCE;
    }

    public List<Employee> findEmployeesCompanyiD(int companyId) {
        try (Connection connection = ConnectionGate.get();
        var preparedStatement = connection.prepareStatement(findEmpCompId)) {
            preparedStatement.setInt(1, companyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Employee> empList = new ArrayList<>();
            while (resultSet.next()) {
                empList.add(new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("status"),
                        resultSet.getInt("companyid")
                ));
            }
            return empList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public Optional<Employee> findId(Integer id) {
        return Optional.empty();
    }

    @Override
    public void updateId(Integer id) {

    }

    @Override
    public void deleteId(Integer id) {

    }
}
