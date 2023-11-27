package junhyeok.umcStudy.converter;

import junhyeok.umcStudy.domain.Review;
import junhyeok.umcStudy.web.dto.ReviewRequestDTO;
import junhyeok.umcStudy.web.dto.ReviewResponseDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.Write dto){
        return Review.builder()
                .body(dto.getBody())
                .score(dto.getScore())
                .build();
    }

    public static ReviewResponseDTO.WriteResult toWriteResult(Review entity){
        return ReviewResponseDTO.WriteResult.builder()
                .reviewId(entity.getId())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
