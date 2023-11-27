package junhyeok.umcStudy.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class MissionResponseDTO {
    @Builder @Getter
    public static class CreateResult{
        Long missionId;
        LocalDateTime createdAt;
    }
}
