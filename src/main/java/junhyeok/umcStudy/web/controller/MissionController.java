package junhyeok.umcStudy.web.controller;

import junhyeok.umcStudy.apiPayload.ApiResponse;
import junhyeok.umcStudy.converter.MissionConverter;
import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.service.MissionCommandService;
import junhyeok.umcStudy.web.dto.MissionRequestDTO;
import junhyeok.umcStudy.web.dto.MissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController @RequestMapping("mission")
@RequiredArgsConstructor
public class MissionController {
    private final MissionCommandService missionService;

    @PostMapping("/create")
    public ApiResponse<MissionResponseDTO.CreateResult> createMission(@Valid @RequestBody MissionRequestDTO.Create request){
        Mission mission = missionService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateResult(mission));
    }
}
