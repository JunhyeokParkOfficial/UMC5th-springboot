package junhyeok.umcStudy.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class Create{
        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotNull
        String missionSpec;
        @NotNull
        Long storeId;
    }

    @Getter
    public static class Start{
        @NotNull
        Long missionId;
        @NotNull
        Long memberId;
    }

    @Getter
    public static class Complete{
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
    }
}
