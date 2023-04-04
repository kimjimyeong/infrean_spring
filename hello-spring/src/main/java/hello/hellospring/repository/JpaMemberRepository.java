package hello.hellospring.repository;

import hello.hellospring.Domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    // jpa는 entitymanager 라는 걸로 모든게 동작한다.
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        // jpa가 알아서 insert query, id까지 알아서 해준다.
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }


    // list를 가지고 돌릴 때 ex) findbyName 은 pk 기반이 아닌 jpql를 작성해줘야한다
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // 객체를 대상으로 query를 날림
        // 객체 자체를 select를 함
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
