package service;

import dao.CompanyDao;
import dto.CompanyDto;

import java.util.List;


import static java.util.stream.Collectors.toList;

public class CompanyService {

    private final static CompanyService INSTANCE = new CompanyService();

    public CompanyService() {
    }

    public static CompanyService getINSTANCE() {
        return INSTANCE;
    }

    private CompanyDao companyDao = CompanyDao.getInstance();

    public List<CompanyDto> findAll() {
        return companyDao.findAll().stream().map(company -> new CompanyDto(
                company.getId(),company.getName())).collect(toList());
    }
}
