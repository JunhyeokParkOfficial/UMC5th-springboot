package junhyeok.umcStudy.service.storeService;

import junhyeok.umcStudy.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findById(Long id);
}
