package junhyeok.umcStudy.service;

import junhyeok.umcStudy.converter.ReviewConverter;
import junhyeok.umcStudy.domain.Review;
import junhyeok.umcStudy.respository.ReviewRepository;
import junhyeok.umcStudy.web.dto.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional @RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberQueryService memberQueryService;
    private final StoreQueryService storeQueryService;

    public Review writeReview(Long storeId, Long memberId, ReviewRequestDTO.Write request) {
        Review newReview = ReviewConverter.toReview(request);
        newReview.setMember(memberQueryService.findById(memberId).get());
        newReview.setStore(storeQueryService.findById(storeId).get());
        return reviewRepository.save(newReview);
    }
}
