package junhyeok.umcStudy.domain;

import junhyeok.umcStudy.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @Builder @NoArgsConstructor @AllArgsConstructor
public class FoodCategory extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 15)
    String name;
}
