package junhyeok.umcStudy.service.memberService;

import junhyeok.umcStudy.domain.Member;
import junhyeok.umcStudy.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
