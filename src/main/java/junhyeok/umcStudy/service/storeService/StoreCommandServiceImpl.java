package junhyeok.umcStudy.service.storeService;

import junhyeok.umcStudy.converter.StoreConverter;
import junhyeok.umcStudy.domain.Region;
import junhyeok.umcStudy.domain.Store;
import junhyeok.umcStudy.respository.StoreRepository;
import junhyeok.umcStudy.service.regionService.RegionQueryService;
import junhyeok.umcStudy.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional @RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final RegionQueryService regionQueryService;

    public Store createStore(StoreRequestDTO.Create request) {
        Store newStore = StoreConverter.toStore(request);
        Region region = regionQueryService.findById(request.getRegionId()).get();
        newStore.setRegion(region);
        return storeRepository.save(newStore);
    }
}
