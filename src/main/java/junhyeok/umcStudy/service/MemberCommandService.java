package junhyeok.umcStudy.service;

import junhyeok.umcStudy.domain.Member;
import junhyeok.umcStudy.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
