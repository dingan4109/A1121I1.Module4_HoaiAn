package phone_validation.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PhoneNumber implements Validator {
    private String number;

    public PhoneNumber() {
    }

    public PhoneNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumber phoneNumber = (PhoneNumber) target;
        String number = phoneNumber.getNumber();

        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");
        if(number.length() > 11 || number.length()<10) {
            errors.rejectValue("number","number.length");
        }
        if(number.charAt(0) != '0') {
            errors.rejectValue("number","number.charAt0");
        }
        if(!number.matches("^[0-9]*$")) {
         errors.rejectValue("number","number.matches");
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
