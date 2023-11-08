package junhyeok.umcStudy.domain.mapping;

import junhyeok.umcStudy.domain.Member;
import junhyeok.umcStudy.domain.Terms;
import junhyeok.umcStudy.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Builder @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
public class MemberAgree extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terms_id")
    private Terms terms;
}
