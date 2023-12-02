package junhyeok.umcStudy.web.controller;

import junhyeok.umcStudy.apiPayload.ApiResponse;
import junhyeok.umcStudy.converter.MemberMissionConverter;
import junhyeok.umcStudy.converter.MissionConverter;
import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.domain.mapping.MemberMission;
import junhyeok.umcStudy.service.missionService.MissionCommandService;
import junhyeok.umcStudy.service.missionService.MissionQueryService;
import junhyeok.umcStudy.validation.annotation.CheckPage;
import junhyeok.umcStudy.validation.annotation.ExistMemberMission;
import junhyeok.umcStudy.web.dto.MissionRequestDTO;
import junhyeok.umcStudy.web.dto.MissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController @RequestMapping("mission")
@RequiredArgsConstructor
@Validated
public class MissionController {
    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/create")
    public ApiResponse<MissionResponseDTO.CreateResult> createMission(@Valid @RequestBody MissionRequestDTO.Create request){
        Mission mission = missionCommandService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateResult(mission));
    }

    @PostMapping("/start")
    public ApiResponse<MissionResponseDTO.StartResult> startMission(@RequestBody @ExistMemberMission MissionRequestDTO.Start request){
        MemberMission memberMission = missionCommandService.startMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toStartResult(memberMission));
    }

    @GetMapping("/store/{storeId}")
    public ApiResponse<MissionResponseDTO.MissionList> getMissionByStore(
            @PathVariable(name = "storeId") Long storeId,
            @CheckPage @RequestParam(name = "page") Integer page){
        Page<Mission> missionList = missionQueryService.getMissionByStore(storeId, page-1);
        MissionResponseDTO.MissionList res = MissionConverter.toList(missionList);
        return ApiResponse.onSuccess(res);
    }
}
