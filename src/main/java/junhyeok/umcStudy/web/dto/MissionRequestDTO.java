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
}
