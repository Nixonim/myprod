package validator;
import validator.ValidationResult;

public interface Validator <T> {
    public ValidationResult isValid(T type);
}