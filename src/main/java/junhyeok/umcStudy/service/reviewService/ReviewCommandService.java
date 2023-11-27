package junhyeok.umcStudy.service.reviewService;

import junhyeok.umcStudy.domain.Review;
import junhyeok.umcStudy.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review writeReview(Long storeId, Long memberId, ReviewRequestDTO.Write request);
}