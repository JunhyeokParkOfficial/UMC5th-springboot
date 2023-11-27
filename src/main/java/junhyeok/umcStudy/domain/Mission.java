package junhyeok.umcStudy.domain;

import junhyeok.umcStudy.domain.common.BaseEntity;
import junhyeok.umcStudy.domain.mapping.MemberMission;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED) @Builder
public class Mission extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "store_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    private Integer reward;

    private LocalDate deadline;

    @Column(columnDefinition = "TEXT")
    private String missionSpec;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    public void setStore(Store store){
        this.store = store;
    }
}
