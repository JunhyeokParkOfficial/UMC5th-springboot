package junhyeok.umcStudy.domain;

import junhyeok.umcStudy.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @Builder @NoArgsConstructor @AllArgsConstructor
public class ReviewImage extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "review_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;
}
