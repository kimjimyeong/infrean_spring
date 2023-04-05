package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // interface만 존재
    private final MemberRepository memberRepository;

    // 의존관계를 외부에서 주입당함 -> DI
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
