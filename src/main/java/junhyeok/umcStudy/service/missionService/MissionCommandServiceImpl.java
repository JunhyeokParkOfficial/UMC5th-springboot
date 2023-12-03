package junhyeok.umcStudy.service.missionService;

import junhyeok.umcStudy.converter.MissionConverter;
import junhyeok.umcStudy.domain.Member;
import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.domain.enums.MissionStatus;
import junhyeok.umcStudy.domain.mapping.MemberMission;
import junhyeok.umcStudy.respository.MemberMissionRepository;
import junhyeok.umcStudy.respository.MissionRepository;
import junhyeok.umcStudy.service.storeService.StoreQueryService;
import junhyeok.umcStudy.service.memberService.MemberQueryService;
import junhyeok.umcStudy.web.dto.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional @RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final StoreQueryService storeQueryService;
    private final MemberQueryService memberQueryService;
    public Mission createMission(MissionRequestDTO.Create request) {
        Mission newMission = MissionConverter.toMission(request);
        Long storeId = request.getStoreId();
        newMission.setStore(storeQueryService.findById(storeId).get());
        return missionRepository.save(newMission);
    }

    @Override
    public MemberMission startMission(MissionRequestDTO.Start request) {
        MemberMission mm = MemberMission.builder().status(MissionStatus.CHALLENGING).build();
        Long memberId = request.getMemberId();
        Long missionId = request.getMissionId();
        mm.setMember(memberQueryService.findById(memberId).get());
        mm.setMission(missionRepository.findById(missionId).get());

        return memberMissionRepository.save(mm);
    }

    @Override
    public MemberMission completeMission(MissionRequestDTO.Complete request) {
        Member member = memberQueryService.findById(request.getMemberId()).get();
        Mission mission = missionRepository.findById(request.getMissionId()).get();
        MemberMission mm = memberMissionRepository.findMemberMissionByMemberAndMission(member,mission).get(0);
        mm.completeMission();

        return mm;
    }
}
