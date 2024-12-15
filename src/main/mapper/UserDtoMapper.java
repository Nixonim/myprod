package mapper;

import dto.UserDtoAuth;
import entity.Users;

public class UserDtoMapper implements Mapper<Users, UserDtoAuth> {

    private static UserDtoMapper userDtoMapper = new UserDtoMapper();

    public static UserDtoMapper getUserDtoMapper() {
        return userDtoMapper;
    }

    @Override
    public UserDtoAuth changeType(Users from) {
        return UserDtoAuth.builder().id(from.getId()).name(from.getName()).image(from.getImage()).email(from.getEmail()).role(from.getRole()).gender(from.getGender()).birthday(from.getBirthday()).password(from.getPassword()).
                build();
    }
}
