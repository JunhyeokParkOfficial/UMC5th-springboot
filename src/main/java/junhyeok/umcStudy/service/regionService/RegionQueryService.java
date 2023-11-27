package junhyeok.umcStudy.service.regionService;

import junhyeok.umcStudy.domain.Region;

import java.util.Optional;

public interface RegionQueryService {
    Optional<Region> findById(Long id);
}
