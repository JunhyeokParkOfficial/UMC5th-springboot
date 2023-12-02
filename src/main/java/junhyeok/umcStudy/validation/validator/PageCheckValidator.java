package junhyeok.umcStudy.validation.validator;

import junhyeok.umcStudy.apiPayload.code.status.ErrorStatus;
import junhyeok.umcStudy.validation.annotation.CheckPage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PageCheckValidator implements ConstraintValidator<CheckPage,Integer> {

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value<1){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_LT_ONE.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
