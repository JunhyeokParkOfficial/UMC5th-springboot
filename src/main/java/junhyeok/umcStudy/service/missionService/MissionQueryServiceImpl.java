package junhyeok.umcStudy.service.missionService;

import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.respository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional @RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    @Override
    public Page<Mission> getMissionByStore(Long storeId, Integer page) {
        return missionRepository.findAllByStore_Id(storeId, PageRequest.of(page,10));
    }
}
