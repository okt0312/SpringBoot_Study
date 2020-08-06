package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

class MemberServiceTest
{
    MemberService memberService;
    MemoryMemberRepository memberRepository;
    
    @BeforeEach
    public void beforeEach()
    {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    
    
    
    @AfterEach
    public void afterEach()
    {
        memberRepository.clearStore();
    }

    @Test
    void ȸ������()
    {
        // given (������ ��� Ȯ�� ����)
        Member member = new Member();
        member.setName("hello");
        
        // when (��� �����ϴ���)
        Long saveId = memberService.join(member);
        
        
        // then (������)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    
    @Test
    public void �ߺ�_ȸ��_����()
    {
        // given
        Member member1 = new Member();
        member1.setName("spring");
        
        Member member2 = new Member();
        member2.setName("spring");
        
        
        // when
        memberService.join(member1);
        
//        try
//        {
//            memberService.join(member2);
//            fail();
//        }
//        catch(IllegalStateException e)
//        {
//            assertThat(e.getMessage()).isEqualTo("�̹� �����ϴ� ȸ���Դϴ�.");
//        }
        
        IllegalStateException e =  assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        
        assertThat(e.getMessage()).isEqualTo("�̹� �����ϴ� ȸ���Դϴ�.");
        
        // then
    }

    @Test
    void testFindMembers()
    {
    }

    @Test
    void testFindOne()
    {
    }

}
