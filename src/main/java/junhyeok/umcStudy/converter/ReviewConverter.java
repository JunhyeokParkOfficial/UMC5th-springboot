package junhyeok.umcStudy.converter;

import junhyeok.umcStudy.domain.Review;
import junhyeok.umcStudy.web.dto.ReviewRequestDTO;
import junhyeok.umcStudy.web.dto.ReviewResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static ReviewResponseDTO.ReviewDetailDTO toReviewDetailDTO(Review review){
        return ReviewResponseDTO.ReviewDetailDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static ReviewResponseDTO.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewList){
        List<ReviewResponseDTO.ReviewDetailDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewDetailDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
