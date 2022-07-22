package skysrd.lostarkraidcollection.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import skysrd.lostarkraidcollection.domain.entity.Character;
import skysrd.lostarkraidcollection.domain.entity.CharacterRaid;
import skysrd.lostarkraidcollection.domain.entity.Member;
import skysrd.lostarkraidcollection.repository.CharacterRaidRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CharacterRaidService {
    private final CharacterRaidRepository characterRaidRepository;

    public List<CharacterRaid> characterRaids() {
        return characterRaidRepository.findAll();
    }

    public List<CharacterRaid> characterRaids(Character character) {
        return characterRaidRepository.findAllByCharacter(character);
    }

    public void checkRaid(CharacterRaid characterRaid) {
        characterRaid.checkRaid();
    }

    public void uncheckRaid(CharacterRaid characterRaid) {
        characterRaid.uncheckRaid();
    }
}
