package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("zandhi");

        repository.save(member);

        //optioinal 객체 꺼내는 get(). 더 좋은 방식이 있다
        Member result = repository.findByName("zandhi").get();
        //Id 출력
        System.out.println("id = " + result.getId() );
        //동일한 객체인지 확인
        System.out.println("result = " + (result == member));

        //Assertions 함수 같으면 정상작동 다르면 빨간불(오류)!
        Assertions.assertEquals(result, member);
        //assertj 의 Assertions.assertThat() 좀더 가독성 편함
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("zandhi");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("missong");
        repository.save(member2);

        Member result = repository.findByName("missong").get();
        org.assertj.core.api.Assertions.assertThat(member2).isEqualTo(result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("zandhi");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("missong");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertEquals(result.size(), 2);
    }
}