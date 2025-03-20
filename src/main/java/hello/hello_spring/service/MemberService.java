package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService{

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

// 1. 회원 가입``   ``
    public Long join(Member member){
        // 중복 이름X
        //Optional<Member> result = memberRepository.findByName(member.getName());
        // Optional 함수 ifPresent: 값이 있으면 파라미터 m(Member)를 받아서 {}코드를 실행해라!
        //result
        validateDuplicateMember(member);
        // get을 쓰면 값을 얻을 수 있지만, 권장하지 않음 그래서 orElseGet(Null이 아니면?)같은 걸 사용해서 처리
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
