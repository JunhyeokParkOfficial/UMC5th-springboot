package junhyeok.umcStudy.respository;

import junhyeok.umcStudy.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Long> {
}
