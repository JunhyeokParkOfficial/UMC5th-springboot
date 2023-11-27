package junhyeok.umcStudy.web.dto;

import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class Create{
        String name;
        String address;
        Long regionId;
    }

}
