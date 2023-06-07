package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() { // 메서드가 끝날 때마다 실행되는 메서드
        repository.clearStore(); // 테스트 한 번 끝날 때 마다 데이터를 초기화해준다
        // why? 테스트는 서로의 의존관계 없이 각자 실행될 수 있어야 한다. 고로 테스트를 한 번씩 할 때마다 DB를 비워주어야 한다.
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        // shift + f6 => 전체 바꿈
        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("John");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Jason");
        repository.save(member2);

        Member result = repository.findByName("John").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("John");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Jason");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
