package skysrd.lostarkraidcollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skysrd.lostarkraidcollection.domain.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);
    List<User> findAll();
}
