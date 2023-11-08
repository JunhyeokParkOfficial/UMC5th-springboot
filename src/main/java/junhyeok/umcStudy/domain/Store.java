package junhyeok.umcStudy.domain;

import junhyeok.umcStudy.domain.common.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Store extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String address;

    private float score;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();
}
