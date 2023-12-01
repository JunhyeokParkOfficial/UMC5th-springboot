package junhyeok.umcStudy.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {
    @Getter
    public static class Write{
        @NotNull
        String title;
        @NotNull
        String body;
        @NotNull
        Float score;
    }
}
