package junhyeok.umcStudy.service;

import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission createMission(MissionRequestDTO.Create request);
}
