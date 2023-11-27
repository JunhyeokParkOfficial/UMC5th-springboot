package junhyeok.umcStudy.validation.validator;

import junhyeok.umcStudy.apiPayload.code.status.ErrorStatus;
import junhyeok.umcStudy.domain.Member;
import junhyeok.umcStudy.domain.Mission;
import junhyeok.umcStudy.domain.mapping.MemberMission;
import junhyeok.umcStudy.respository.MemberMissionRespository;
import junhyeok.umcStudy.respository.MemberRepository;
import junhyeok.umcStudy.respository.MissionRepository;
import junhyeok.umcStudy.validation.annotation.ExistMemberMission;
import junhyeok.umcStudy.web.dto.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberMissionExistValidator implements ConstraintValidator<ExistMemberMission, MissionRequestDTO.Start> {
    private final MemberMissionRespository memberMissionRespository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    @Override
    public void initialize(ExistMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionRequestDTO.Start value, ConstraintValidatorContext context) {
        Member member = memberRepository.findById(value.getMemberId()).get();
        Mission mission = missionRepository.findById(value.getMissionId()).get();
        List<MemberMission> mm = memberMissionRespository
                .findMemberMissionByMemberAndMission(member,mission);
        if(mm.size()!=0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_START.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
