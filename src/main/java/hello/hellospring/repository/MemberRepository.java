package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 저장
    Optional<Member> findById(Long id); // id로 회원을 찾음
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 지금까지 저장된 회원 리스트 반환

}
