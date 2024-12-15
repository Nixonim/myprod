package validator;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationResult {
    public List<Errors> errors = new ArrayList<>();

    public void add (Errors error) {
        errors.add(error);
    }

}
