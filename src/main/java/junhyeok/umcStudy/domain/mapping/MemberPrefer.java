package junhyeok.umcStudy.domain.mapping;

import junhyeok.umcStudy.domain.FoodCategory;
import junhyeok.umcStudy.domain.Member;
import junhyeok.umcStudy.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
public class MemberPrefer extends BaseEntity {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    FoodCategory foodCategory;
}
