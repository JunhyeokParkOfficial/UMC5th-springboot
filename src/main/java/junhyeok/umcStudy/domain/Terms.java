package junhyeok.umcStudy.domain;

import junhyeok.umcStudy.domain.common.BaseEntity;
import junhyeok.umcStudy.domain.mapping.MemberAgree;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Builder @AllArgsConstructor @NoArgsConstructor
public class Terms extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private Boolean optional;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();
}
