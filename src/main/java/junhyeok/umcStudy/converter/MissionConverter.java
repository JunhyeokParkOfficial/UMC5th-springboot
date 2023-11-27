package junhyeok.umcStudy.converter;

import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.web.dto.MissionRequestDTO;
import junhyeok.umcStudy.web.dto.MissionResponseDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.Create dto){
        return Mission.builder()
                .reward(dto.getReward())
                .deadline(dto.getDeadline())
                .missionSpec(dto.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.CreateResult toCreateResult(Mission entity){
        return MissionResponseDTO.CreateResult.builder()
                .missionId(entity.getId())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
