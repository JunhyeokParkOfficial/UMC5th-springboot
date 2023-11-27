package junhyeok.umcStudy.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class ReviewResponseDTO {
    @Getter
    @Builder
    public static class WriteResult{
        Long reviewId;
        LocalDateTime createdAt;
    }
}
