package junhyeok.umcStudy.service.storeService;

import junhyeok.umcStudy.domain.Store;
import junhyeok.umcStudy.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO.Create request);
}
