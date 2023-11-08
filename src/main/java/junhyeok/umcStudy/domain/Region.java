package junhyeok.umcStudy.domain;

import junhyeok.umcStudy.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder @Getter @NoArgsConstructor @AllArgsConstructor
public class Region extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=20)
    private String name;
}
