package junhyeok.umcStudy.service;

import junhyeok.umcStudy.domain.Region;
import junhyeok.umcStudy.respository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service @Transactional @RequiredArgsConstructor
public class RegionQueryServiceImpl implements RegionQueryService {

    private final RegionRepository regionRepository;

    public Optional<Region> findById(Long id) {
        return regionRepository.findById(id);
    }
}
