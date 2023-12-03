package junhyeok.umcStudy.respository;

import junhyeok.umcStudy.domain.Member;
import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {
    List<MemberMission> findMemberMissionByMemberAndMission(Member member, Mission mission);

    @Query("select mm from MemberMission mm where mm.member.id = :memberId and mm.status='CHALLENGING'")
    Page<MemberMission> findAllByMember_Id(@Param("memberId")Long memberId, PageRequest pageRequest);

    @Query(value= "select mm from MemberMission mm join fetch mm.member m join fetch mm.mission mi join fetch mi.store where mm.member.id=:memberId and mm.status='CHALLENGING'",
    countQuery = "select count(mm) from MemberMission mm where mm.member.id=:memberId and mm.status='CHALLENGING'")
    Page<MemberMission> findMemberMissions(@Param("memberId") Long memberId, Pageable page);
}
