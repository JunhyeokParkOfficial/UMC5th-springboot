package junhyeok.umcStudy.service.missionService;

import junhyeok.umcStudy.domain.Mission;
import org.springframework.data.domain.Page;

public interface MissionQueryService {
    Page<Mission> getMissionByStore(Long storeId, Integer page);
}
