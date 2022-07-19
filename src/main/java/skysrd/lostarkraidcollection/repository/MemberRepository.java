package skysrd.lostarkraidcollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skysrd.lostarkraidcollection.domain.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long id);
    List<Member> findAll();
    Optional<Member> findByUsername(String username);
    Boolean existsByUsername(String username);
}
