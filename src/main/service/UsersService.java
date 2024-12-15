package service;

import lombok.Getter;
import lombok.SneakyThrows;
import dao.UsersDao;
import dto.UserDtoAuth;
import dto.UsersDto;
import entity.Users;
import mapper.UserDtoMapper;
import mapper.UserMapper;
import validator.UsersValidation;
import validator.ValidationExeption;
import validator.ValidationResult;

import java.util.Optional;

public class UsersService {

    @Getter
    private static UsersService INSTANCE = new UsersService();
    UserMapper userMapper = UserMapper.getUserMapper();
    UsersDao usersDao = UsersDao.getINSTANCE();
    UsersValidation usersValidation = UsersValidation.getUsersValidation();
    ImageService imageService = ImageService.getImageService();
    UserDtoMapper userDtoMapper = UserDtoMapper.getUserDtoMapper();



   public Optional<UserDtoAuth> findByUsersAuth (String email, String password) {
       return usersDao.findByUsersAuth(email,password).map(users -> userDtoMapper.changeType(users));
   };


    @SneakyThrows
    public Integer create (UsersDto user) {
        ValidationResult valid = usersValidation.isValid(user);
        if (!valid.errors.isEmpty()) {
            throw new ValidationExeption(valid.getErrors());
        }
        Users users = userMapper.changeType(user);
        imageService.upload(users.getImage(), user.getImage().getInputStream());
        System.out.println(users.getImage());
        Users ResultUser = usersDao.сreate(users);
       return ResultUser.getId();
    }
}
