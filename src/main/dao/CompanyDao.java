package dao;

import entity.Company;
import util.ConnectionGate;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompanyDao implements Dao<Integer, Company> {

    // новая строка
// fdf

    //dsdasf
    private final static CompanyDao instance = new CompanyDao();

    public static CompanyDao getInstance() {
        return instance;
    }


    private final String findAllSql =
    """
    SELECT *
    FROM Company;
    """;
    @Override
    public List<Company> findAll() {
        try (Connection connection = ConnectionGate.get();
        var stat = connection.prepareStatement(findAllSql)) {
            ResultSet resultSet = stat.executeQuery();
            ArrayList<Company> companies = new ArrayList<>();
            while (resultSet.next()) {
                companies.add(new Company(resultSet.getInt("id")
                        ,resultSet.getString("name"),resultSet.getDate("date")));
            }
            return companies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Company> findId(Integer id) {
        return Optional.empty();
    }

    @Override
    public void updateId(Integer id) {

    }

    @Override
    public void deleteId(Integer id) {

    }
}
