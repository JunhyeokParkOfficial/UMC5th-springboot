package junhyeok.umcStudy.service;

import junhyeok.umcStudy.converter.MissionConverter;
import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.respository.MissionRepository;
import junhyeok.umcStudy.web.dto.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional @RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final StoreQueryService storeQueryService;
    public Mission createMission(MissionRequestDTO.Create request) {
        Mission newMission = MissionConverter.toMission(request);
        Long storeId = request.getStoreId();
        newMission.setStore(storeQueryService.findById(storeId).get());
        return missionRepository.save(newMission);
    }
}
