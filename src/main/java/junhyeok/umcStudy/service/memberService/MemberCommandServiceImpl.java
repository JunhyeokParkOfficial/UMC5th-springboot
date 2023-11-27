package junhyeok.umcStudy.service.memberService;

import junhyeok.umcStudy.apiPayload.code.status.ErrorStatus;
import junhyeok.umcStudy.apiPayload.exception.handler.FoodCategoryHandler;
import junhyeok.umcStudy.converter.MemberConverter;
import junhyeok.umcStudy.converter.MemberPreferConverter;
import junhyeok.umcStudy.domain.FoodCategory;
import junhyeok.umcStudy.domain.Member;
import junhyeok.umcStudy.domain.mapping.MemberPrefer;
import junhyeok.umcStudy.respository.FoodCategoryRepository;
import junhyeok.umcStudy.respository.MemberRepository;
import junhyeok.umcStudy.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});
        return memberRepository.save(newMember);
    }
}