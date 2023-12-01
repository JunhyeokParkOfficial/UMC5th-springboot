package junhyeok.umcStudy.service.reviewService;

import junhyeok.umcStudy.domain.Review;
import org.springframework.data.domain.Page;

public interface ReviewQueryService {
        Page<Review> getReviewList(Long StoreId, Integer page);
}
