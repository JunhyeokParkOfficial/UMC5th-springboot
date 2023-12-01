package junhyeok.umcStudy.service.reviewService;

import junhyeok.umcStudy.domain.Review;
import junhyeok.umcStudy.domain.Store;
import junhyeok.umcStudy.respository.ReviewRepository;
import junhyeok.umcStudy.service.storeService.StoreQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional @RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;
    private final StoreQueryService storeQueryService;
    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {

        Store store = storeQueryService.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }
}
