package junhyeok.umcStudy.apiPayload.exception.handler;

import junhyeok.umcStudy.apiPayload.code.BaseErrorCode;
import junhyeok.umcStudy.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
