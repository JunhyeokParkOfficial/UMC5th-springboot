package junhyeok.umcStudy.web.dto;

import junhyeok.umcStudy.domain.enums.MissionStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {
    @Builder @Getter
    public static class CreateResult{
        Long missionId;
        LocalDateTime createdAt;
    }

    @Builder @Getter
    public static class StartResult{
        Long memberMissionId;
        LocalDateTime createdAt;
    }

    @Builder @Getter
    public static class MissionList{
        List<Detail> list;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder @Getter
    public static class Detail{
        Long id;
        Integer reward;
        String storeName;
        String missionSpec;
    }

    @Builder @Getter
    public static class Complete{
        Long id;
        MissionStatus status;
        LocalDateTime updatedAt;
    }
}
