package junhyeok.umcStudy.respository;

import junhyeok.umcStudy.domain.Review;
import junhyeok.umcStudy.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);

    Page<Review> findAllByMember_Id(Long memberId, PageRequest pageRequest);
}
