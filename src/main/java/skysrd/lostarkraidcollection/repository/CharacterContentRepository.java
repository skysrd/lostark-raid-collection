package skysrd.lostarkraidcollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skysrd.lostarkraidcollection.domain.entity.Character;
import skysrd.lostarkraidcollection.domain.entity.CharacterContent;
import skysrd.lostarkraidcollection.domain.entity.Raid;

import java.util.List;

public interface CharacterContentRepository extends JpaRepository<CharacterContent, Long> {

    List<CharacterContent> findAll();
    List<CharacterContent> findAllByCharacter(Character character);
    List<CharacterContent> findAllByRaid(Raid raid);
    CharacterContent findByCharacterAndRaid(Character character, Raid raid);

}
