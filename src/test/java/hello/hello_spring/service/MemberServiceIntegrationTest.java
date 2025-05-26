package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("조동컥");
        //when
        Long memberId = memberService.join(member);
        //then
        memberService.findOne(memberId)
                .ifPresentOrElse(
                        m->{Assertions.assertEquals(member.getName(), m.getName());},
                        ()->{Assertions.fail();}
                );
    }

    @Test
    void 회원가입_중복_예외() throws Exception{
        //given
        //when
        //then
    }
}
