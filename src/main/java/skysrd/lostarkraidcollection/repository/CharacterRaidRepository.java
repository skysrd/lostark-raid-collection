package skysrd.lostarkraidcollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skysrd.lostarkraidcollection.domain.entity.Character;
import skysrd.lostarkraidcollection.domain.entity.CharacterRaid;
import skysrd.lostarkraidcollection.domain.entity.Raid;

import java.util.List;

public interface CharacterRaidRepository extends JpaRepository<CharacterRaid, Long> {

    List<CharacterRaid> findAll();
    List<CharacterRaid> findAllByCharacter(Character character);
    List<CharacterRaid> findAllByRaid(Raid raid);
}
