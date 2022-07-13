package skysrd.lostarkraidcollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skysrd.lostarkraidcollection.domain.entity.CharacterRaid;

public interface CharacterRaidRepository extends JpaRepository<CharacterRaid, Long> {

}
