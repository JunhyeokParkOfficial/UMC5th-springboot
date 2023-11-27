package junhyeok.umcStudy.web.controller;

import junhyeok.umcStudy.apiPayload.ApiResponse;
import junhyeok.umcStudy.converter.MemberConverter;
import junhyeok.umcStudy.domain.Member;
import junhyeok.umcStudy.service.MemberCommandService;
import junhyeok.umcStudy.web.dto.MemberRequestDTO;
import junhyeok.umcStudy.web.dto.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
