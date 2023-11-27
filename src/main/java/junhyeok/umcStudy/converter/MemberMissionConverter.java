package junhyeok.umcStudy.converter;

import junhyeok.umcStudy.domain.mapping.MemberMission;
import junhyeok.umcStudy.web.dto.MissionResponseDTO;

public class MemberMissionConverter {
    public static MissionResponseDTO.StartResult toStartResult(MemberMission entity){
        return MissionResponseDTO.StartResult.builder()
                .memberMissionId(entity.getId())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
