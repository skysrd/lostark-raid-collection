package skysrd.lostarkraidcollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skysrd.lostarkraidcollection.domain.entity.Character;
import skysrd.lostarkraidcollection.domain.entity.User;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    Character findCharacterById(Long id);
    List<Character> findAllByParentUser(User user);
    List<Character> findAll();
}
