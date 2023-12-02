package junhyeok.umcStudy.validation.annotation;

import junhyeok.umcStudy.validation.validator.PageCheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageCheckValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "잘못된 페이지입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}