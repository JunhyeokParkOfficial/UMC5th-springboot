package junhyeok.umcStudy.validation.validator;

import junhyeok.umcStudy.apiPayload.code.status.ErrorStatus;
import junhyeok.umcStudy.domain.Store;
import junhyeok.umcStudy.service.StoreQueryService;
import junhyeok.umcStudy.validation.annotation.ExistStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreQueryService storeQueryService;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<Store> target = storeQueryService.findById(value);
        System.out.println("가게 체크시작");
        if (target.isEmpty()){
            System.out.println("가게 체크실패!");
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}