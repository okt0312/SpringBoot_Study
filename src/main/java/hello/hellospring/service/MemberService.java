package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberService
{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    
    /**
     * ȸ�� ����
     * @param member
     * @return
     */
    public Long join(Member member)
    {
        // ���� �̸��� �ִ� �ߺ� ȸ��X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    
    private void validateDuplicateMember(Member member)
    {
        memberRepository.findByName(member.getName())
               .ifPresent(m -> { // result�� ���� ���� ��
                   throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
               });
    }
    
    /**
     * ��ü ȸ�� ��ȸ
     * @return
     */
    public List<Member> findMembers()
    {
        return memberRepository.findAll();
    }
    
    public Optional<Member> findOne(Long memberId)
    {
        return memberRepository.findById(memberId);
    }
}
