package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    // ctrl + shift + t => 테스트 파일을 자동으로 만들 수 있음


    private final MemberRepository memberRepository;

    // memberRepository를 외부에서 넣어줌 => 디펜던시 인젝션(DI, 의존성 주입)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    // 같은 이름이 있는 중복 회원 X
    public void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> { // 만약 값이 있으면
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    // 회원가입
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
