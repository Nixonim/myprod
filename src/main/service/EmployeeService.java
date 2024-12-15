package service;

import dao.EmployeeDao;
import dto.EmployeeDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class EmployeeService {
    private static EmployeeService INSTANCE = new EmployeeService();

    public static EmployeeService getINSTANCE() {
        return INSTANCE;
    }

    EmployeeDao employeeDao = EmployeeDao.getINSTANCE();


    public List<EmployeeDto> findEmpInCompany(int companyId) {
        return employeeDao.findEmployeesCompanyiD(companyId).stream().map(employee -> new EmployeeDto(
                employee.getId(), employee.getName(), employee.getStatus())).collect(toList());

    }
}
