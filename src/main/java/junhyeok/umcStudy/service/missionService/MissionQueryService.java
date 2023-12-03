package junhyeok.umcStudy.service.missionService;

import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;


public interface MissionQueryService {
    Page<Mission> getMissionByStore(Long storeId, Integer page);

    Page<MemberMission> getMissionByMember(Long memberId, Integer page);
}
