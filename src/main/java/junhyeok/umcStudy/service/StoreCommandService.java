package junhyeok.umcStudy.service;

import junhyeok.umcStudy.domain.Store;
import junhyeok.umcStudy.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO.Create request);
}
