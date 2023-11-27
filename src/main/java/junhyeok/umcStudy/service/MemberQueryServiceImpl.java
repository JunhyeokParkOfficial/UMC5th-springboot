package junhyeok.umcStudy.service;

import junhyeok.umcStudy.domain.Member;
import junhyeok.umcStudy.respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service @Transactional(readOnly = true) @RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }
}
