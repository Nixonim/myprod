package validator;

import lombok.Getter;

import java.util.List;

public class ValidationExeption extends RuntimeException{
    @Getter
    private final List<Errors> errors;

    public ValidationExeption(List<Errors> errors) {
        this.errors = errors;
    }


}
