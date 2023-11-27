package junhyeok.umcStudy.web.controller;

import junhyeok.umcStudy.apiPayload.ApiResponse;
import junhyeok.umcStudy.converter.ReviewConverter;
import junhyeok.umcStudy.domain.Review;
import junhyeok.umcStudy.service.ReviewCommandService;
import junhyeok.umcStudy.validation.annotation.ExistMember;
import junhyeok.umcStudy.validation.annotation.ExistStore;
import junhyeok.umcStudy.web.dto.ReviewRequestDTO;
import junhyeok.umcStudy.web.dto.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @RequestMapping("/review")
@RequiredArgsConstructor
@Validated
public class ReviewController {
    private final ReviewCommandService reviewService;

    @PostMapping("/create/{storeId}")
    public ApiResponse<ReviewResponseDTO.WriteResult> writeReview(@ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                  @ExistMember @RequestParam(name = "memberId") Long memberId,
                                                                  @Valid @RequestBody ReviewRequestDTO.Write request){
        Review review = reviewService.writeReview(storeId,memberId,request);
        return ApiResponse.onSuccess(ReviewConverter.toWriteResult(review));
    }
}
