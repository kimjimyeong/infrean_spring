package hello.hellospring.repository;

import hello.hellospring.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// long = member id type, interface는 다중상속이 된다.
// spring data jpa가 구현체를 자동으로 만들어서 spring bean에 알아서 등록해준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {


    @Override
    Optional<Member> findByName(String name);
}