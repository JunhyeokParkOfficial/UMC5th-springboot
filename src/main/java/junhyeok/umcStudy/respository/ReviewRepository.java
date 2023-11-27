package junhyeok.umcStudy.respository;

import junhyeok.umcStudy.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
