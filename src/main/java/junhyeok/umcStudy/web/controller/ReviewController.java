package junhyeok.umcStudy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import junhyeok.umcStudy.apiPayload.ApiResponse;
import junhyeok.umcStudy.converter.ReviewConverter;
import junhyeok.umcStudy.domain.Review;
import junhyeok.umcStudy.service.reviewService.ReviewCommandService;
import junhyeok.umcStudy.service.reviewService.ReviewQueryService;
import junhyeok.umcStudy.validation.annotation.CheckPage;
import junhyeok.umcStudy.validation.annotation.ExistMember;
import junhyeok.umcStudy.validation.annotation.ExistStore;
import junhyeok.umcStudy.web.dto.ReviewRequestDTO;
import junhyeok.umcStudy.web.dto.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @RequestMapping("/review")
@RequiredArgsConstructor
@Validated
public class ReviewController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/create/{storeId}")
    public ApiResponse<ReviewResponseDTO.WriteResult> writeReview(@ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                  @ExistMember @RequestParam(name = "memberId") Long memberId,
                                                                  @Valid @RequestBody ReviewRequestDTO.Write request){
        Review review = reviewCommandService.writeReview(storeId,memberId,request);
        return ApiResponse.onSuccess(ReviewConverter.toWriteResult(review));
    }

    @GetMapping("{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name="storeId") Long storeId, @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = reviewQueryService.getReviewList(storeId,page);
        ReviewResponseDTO.ReviewPreViewListDTO res = ReviewConverter.toReviewPreViewListDTO(reviewList);
        return ApiResponse.onSuccess(res);
    }

    @GetMapping("member/{memberId}")
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getMyReviewList(
            @ExistMember @PathVariable(name="memberId") Long memberId,
            @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = reviewQueryService.getMyReviewList(memberId, page-1);
        return ApiResponse.onSuccess(ReviewConverter.toReviewPreViewListDTO(reviewList));
    }
}
