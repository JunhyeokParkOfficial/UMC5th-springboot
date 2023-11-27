package junhyeok.umcStudy.converter;

import junhyeok.umcStudy.domain.Store;
import junhyeok.umcStudy.web.dto.StoreRequestDTO;
import junhyeok.umcStudy.web.dto.StoreResponseDTO;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class StoreConverter {

    public static Store toStore(StoreRequestDTO.Create request){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .reviewList(new ArrayList<>())
                .build();
    }
    public static StoreResponseDTO.CreateResult toCreateResult(Store store){
        return StoreResponseDTO.CreateResult.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }
}
