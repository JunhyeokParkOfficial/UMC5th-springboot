package junhyeok.umcStudy.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class StoreResponseDTO {
    @Builder
    @Getter
    public static class CreateResult{
        Long storeId;
        LocalDateTime createdAt;
    }
}
