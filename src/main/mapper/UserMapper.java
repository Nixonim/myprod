package mapper;

import Formatter.FormatLocalDate;
import dto.UsersDto;
import entity.EnumGenders;
import entity.EnumRoles;
import entity.Users;

public class UserMapper implements Mapper<UsersDto, Users> {
    private final String FOLDER_IMAGE = "users/";

    private static UserMapper userMapper = new UserMapper();

    public static UserMapper getUserMapper() {
        return userMapper;
    }

    @Override
    public Users changeType(UsersDto from) {
        return Users.builder().name(from.getName()).birthday(FormatLocalDate.format(from.getBirthday())).password(from.getPassword()).email(from.getEmail())
                .gender((EnumGenders.valueOf(from.getGender()))).role(EnumRoles.valueOf(from.getRole())).image(FOLDER_IMAGE + from.getImage().getSubmittedFileName()).
                build();
    }

}
