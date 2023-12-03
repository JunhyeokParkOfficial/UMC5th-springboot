package junhyeok.umcStudy.converter;

import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.domain.mapping.MemberMission;
import junhyeok.umcStudy.web.dto.MissionRequestDTO;
import junhyeok.umcStudy.web.dto.MissionResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.MissionList toList(Page<Mission> entities) {
        List<MissionResponseDTO.Detail> list = entities.stream().map(MissionConverter::toDetail).collect(Collectors.toList());

        return MissionResponseDTO.MissionList.builder()
                .list(list)
                .totalPage(entities.getTotalPages())
                .listSize(entities.getSize())
                .totalElements(entities.getTotalElements())
                .isFirst(entities.isFirst())
                .isLast(entities.isLast())
                .build();
    }

    public static MissionResponseDTO.Detail toDetail(Mission entity){
        return MissionResponseDTO.Detail.builder()
                .id(entity.getId())
                .storeName(entity.getStore().getName())
                .missionSpec(entity.getMissionSpec())
                .reward(entity.getReward())
                .build();
    }

    public static MissionResponseDTO.MissionList memberMissionToList(Page<MemberMission> memberMissions){
        List<MissionResponseDTO.Detail> list =
                memberMissions.stream().map(MissionConverter::memberMissionToDetail).collect(Collectors.toList());

        return MissionResponseDTO.MissionList.builder()
                .list(list)
                .totalPage(memberMissions.getTotalPages())
                .listSize(memberMissions.getSize())
                .totalElements(memberMissions.getTotalElements())
                .isLast(memberMissions.isLast())
                .isFirst(memberMissions.isFirst())
                .build();
    }

    public static MissionResponseDTO.Detail memberMissionToDetail(MemberMission memberMission){
        return MissionResponseDTO.Detail.builder()
                .id(memberMission.getMission().getId())
                .storeName(memberMission.getMission().getStore().getName())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .reward(memberMission.getMission().getReward())
                .build();
    }
}
