package junhyeok.umcStudy.respository;

import junhyeok.umcStudy.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission,Long> {
}
