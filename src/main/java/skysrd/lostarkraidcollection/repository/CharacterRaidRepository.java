package skysrd.lostarkraidcollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skysrd.lostarkraidcollection.domain.entity.Character;
import skysrd.lostarkraidcollection.domain.entity.CharacterRaid;
import skysrd.lostarkraidcollection.domain.entity.Raid;
import skysrd.lostarkraidcollection.domain.request.CharacterRaidRequest;

import java.util.List;
import java.util.Optional;

public interface CharacterRaidRepository extends JpaRepository<CharacterRaid, Long> {

    List<CharacterRaid> findAll();
    List<CharacterRaid> findAllByCharacter(Character character);
    List<CharacterRaid> findAllByRaid(Raid raid);
    CharacterRaid findByCharacterAndRaid(Character character, Raid raid);

}
