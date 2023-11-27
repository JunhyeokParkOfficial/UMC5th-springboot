package junhyeok.umcStudy.domain.mapping;

import junhyeok.umcStudy.domain.Member;
import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.domain.common.BaseEntity;
import junhyeok.umcStudy.domain.enums.MissionStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Builder @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @JoinColumn(name = "mission_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private MissionStatus status;

    public void setMember(Member member){
        this.member = member;
    }

    public void setMission(Mission mission){
        this.mission = mission;
    }
}
