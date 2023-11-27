package junhyeok.umcStudy.apiPayload.exception.handler;

import junhyeok.umcStudy.apiPayload.code.BaseErrorCode;
import junhyeok.umcStudy.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
