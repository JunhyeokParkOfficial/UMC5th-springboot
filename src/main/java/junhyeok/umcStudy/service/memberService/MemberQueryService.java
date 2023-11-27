package junhyeok.umcStudy.service.memberService;

import junhyeok.umcStudy.domain.Member;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findById(Long id);
}
