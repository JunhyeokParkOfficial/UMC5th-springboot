package junhyeok.umcStudy.respository;

import junhyeok.umcStudy.domain.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission,Long> {
    Page<Mission> findAllByStore_Id(Long id, PageRequest pageRequest);
}
