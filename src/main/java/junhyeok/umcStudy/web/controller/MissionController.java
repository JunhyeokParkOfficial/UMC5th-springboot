package junhyeok.umcStudy.web.controller;

import junhyeok.umcStudy.apiPayload.ApiResponse;
import junhyeok.umcStudy.converter.MemberMissionConverter;
import junhyeok.umcStudy.converter.MissionConverter;
import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.domain.mapping.MemberMission;
import junhyeok.umcStudy.service.missionService.MissionCommandService;
import junhyeok.umcStudy.validation.annotation.ExistMemberMission;
import junhyeok.umcStudy.web.dto.MissionRequestDTO;
import junhyeok.umcStudy.web.dto.MissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController @RequestMapping("mission")
@RequiredArgsConstructor
@Validated
public class MissionController {
    private final MissionCommandService missionService;

    @PostMapping("/create")
    public ApiResponse<MissionResponseDTO.CreateResult> createMission(@Valid @RequestBody MissionRequestDTO.Create request){
        Mission mission = missionService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateResult(mission));
    }

    @PostMapping("/start")
    public ApiResponse<MissionResponseDTO.StartResult> startMission(@RequestBody @ExistMemberMission MissionRequestDTO.Start request){
        MemberMission memberMission = missionService.startMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toStartResult(memberMission));
    }
}
