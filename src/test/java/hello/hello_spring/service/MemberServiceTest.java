package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {
    MemoryMemberRepository memberRepository;
    MemberService memberService;
    @BeforeEach
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService  = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입(){
        //given
        Member member = new Member();
        member.setName("Dokkie");
        //when
        Long saveId = memberService.join(member);
        //then
        memberService.findOne(saveId).ifPresent(m->{Assertions.assertEquals(m.getName(),member.getName());});
    }

    @Test
    void 회원가입_중복_예외(){
        //given
        Member member1 = new Member();
        member1.setName("zandhi");
        Member member2 = new Member();
        member2.setName("zandhi");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()->memberService.join(member2));
        Assertions.assertEquals(e.getMessage(), "이미 존재하는 회원입니다.");
/*
        try{
            memberService.join(member2);
            Assertions.fail();
        }catch(IllegalStateException e){
            Assertions.assertEquals(e.getMessage(),"이미 존재하는 회원입니다.");
            Assertions.assertEquals(memberService.findMembers().size(),1);
        }
*/
        //then
    }

    @Test
    void 회원불러오기(){

    }

    @Test
    void findOne(){

    }
}
