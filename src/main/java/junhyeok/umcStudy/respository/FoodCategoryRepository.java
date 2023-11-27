package junhyeok.umcStudy.respository;

import junhyeok.umcStudy.domain.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
