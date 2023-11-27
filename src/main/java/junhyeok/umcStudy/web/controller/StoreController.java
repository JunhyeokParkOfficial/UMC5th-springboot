package junhyeok.umcStudy.web.controller;

import junhyeok.umcStudy.apiPayload.ApiResponse;
import junhyeok.umcStudy.converter.StoreConverter;
import junhyeok.umcStudy.domain.Store;
import junhyeok.umcStudy.service.StoreCommandService;
import junhyeok.umcStudy.web.dto.StoreRequestDTO;
import junhyeok.umcStudy.web.dto.StoreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/create")
    public ApiResponse<StoreResponseDTO.CreateResult> createStore(@RequestBody StoreRequestDTO.Create request){
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateResult(store));
    }
}
