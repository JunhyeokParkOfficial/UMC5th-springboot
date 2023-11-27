package junhyeok.umcStudy.respository;

import junhyeok.umcStudy.domain.Member;
import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberMissionRespository extends JpaRepository<MemberMission,Long> {
    List<MemberMission> findMemberMissionByMemberAndMission(Member member, Mission mission);
}
