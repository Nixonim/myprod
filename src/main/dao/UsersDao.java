package dao;

import lombok.Getter;
import lombok.SneakyThrows;

import entity.EnumGenders;
import entity.EnumRoles;
import entity.Users;
import util.ConnectionGate;

import java.sql.*;
import java.util.Optional;

public class UsersDao {
    @Getter
    private static final UsersDao INSTANCE = new UsersDao();


    private String createSql = """
            insert into Users(name,birthday,email,password,gender,role,image)
            values (?,?,?,?,?,?,?)
            """;

    private String findAuthSql = """
            SELECT * FROM Users 
            where email = ? and password = ?
            
            """;

    private UsersDao() {
    }

    @SneakyThrows
    public Optional<Users> findByUsersAuth(String email, String password) {
        try (Connection connection = ConnectionGate.get();
             var prep = connection.prepareStatement(findAuthSql)) {
            prep.setObject(1, email);
            prep.setObject(2, password);
            ResultSet resultSet = prep.executeQuery();
            Users users = null;
            if (resultSet.next()) {
                users = Users.builder().id(resultSet.getObject("id", Integer.class)).name(resultSet.getObject("name", String.class))
                        .image(resultSet.getObject("image", String.class)).role(EnumRoles.valueOf(resultSet.getObject("role", String.class))).gender(EnumGenders.valueOf(resultSet.getObject("gender", String.class)))
                        .birthday(resultSet.getObject("birthday", Date.class).toLocalDate())
                        .email(resultSet.getObject("email", String.class)).password(resultSet.getObject("password", String.class)).build();
            }
            return Optional.ofNullable(users);
        }
    }

    public Users сreate(Users entity) {
        try (Connection connection = ConnectionGate.get();
        var prep = connection.prepareStatement(createSql, Statement.RETURN_GENERATED_KEYS)) {
            prep.setObject(1,entity.getName());
            prep.setObject(2, entity.getBirthday());
            prep.setObject(3,entity.getEmail());
            prep.setObject(4, entity.getPassword());
            prep.setObject(5,entity.getGender().name());
            prep.setObject(6, entity.getRole().name());
            prep.setObject(7,entity.getImage());
            prep.executeUpdate();
            ResultSet generatedKeys = prep.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getInt("id"));
            return entity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
