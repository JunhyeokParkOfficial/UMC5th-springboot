package junhyeok.umcStudy.service.storeService;

import junhyeok.umcStudy.domain.Store;
import junhyeok.umcStudy.respository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service @Transactional(readOnly = true) @RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService {
    private final StoreRepository storeRepository;
    public Optional<Store> findById(Long id) {
        return storeRepository.findById(id);
    }
}
