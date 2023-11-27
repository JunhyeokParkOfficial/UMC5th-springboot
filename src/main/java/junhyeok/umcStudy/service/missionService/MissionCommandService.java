package junhyeok.umcStudy.service.missionService;

import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.domain.mapping.MemberMission;
import junhyeok.umcStudy.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission createMission(MissionRequestDTO.Create request);

    MemberMission startMission(MissionRequestDTO.Start request);
}
