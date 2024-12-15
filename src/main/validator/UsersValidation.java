package validator;

import lombok.Getter;
import dto.UsersDto;
import validator.Errors;
import validator.ValidationResult;
public class UsersValidation implements Validator<UsersDto> {

    @Getter
    private static UsersValidation usersValidation = new UsersValidation();

    @Override
    public ValidationResult isValid(UsersDto type) {
        ValidationResult validationResult = new ValidationResult();
        if (type.getPassword().length()<8) {
            Errors errors = new Errors();
            errors.setMassage("Пароль меньше 10 цифр - установите больше !!!!!!");
            validationResult.add(errors);
        }
        return validationResult;
    }
}
