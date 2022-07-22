package skysrd.lostarkraidcollection.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import skysrd.lostarkraidcollection.domain.entity.Character;
import skysrd.lostarkraidcollection.domain.entity.CharacterRaid;
import skysrd.lostarkraidcollection.domain.entity.Member;
import skysrd.lostarkraidcollection.domain.request.CharacterRaidRequest;
import skysrd.lostarkraidcollection.repository.CharacterRaidRepository;
import skysrd.lostarkraidcollection.repository.CharacterRepository;
import skysrd.lostarkraidcollection.repository.MemberRepository;
import skysrd.lostarkraidcollection.repository.RaidRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CharacterRaidService {
    private final CharacterRaidRepository characterRaidRepository;
    private final CharacterRepository characterRepository;
    private final RaidRepository raidRepository;

    public List<CharacterRaid> characterRaids() {
        return characterRaidRepository.findAll();
    }

    public List<CharacterRaid> characterRaids(Character character) {
        return characterRaidRepository.findAllByCharacter(character);
    }

    public CharacterRaid createCharacterRaid(CharacterRaidRequest characterRaidRequest) {
        CharacterRaid characterRaid = CharacterRaid.builder()
                .character(characterRepository.findCharacterById(characterRaidRequest.getCharacterId()))
                .raid(raidRepository.findRaidById(characterRaidRequest.getRaidId()))
                .build();

        characterRaidRepository.save(characterRaid);
        return characterRaid;

    }

    public CharacterRaid checkRaid(CharacterRaidRequest characterRaidRequest) {
        Character character = characterRepository.findById(characterRaidRequest.getCharacterId());
        characterRaid.checkRaid();
        return characterRaid;
    }

    public CharacterRaid uncheckRaid(CharacterRaidRequest characterRaidRequest) {
        Character character = characterRepository.findById(characterRaidRequest.getCharacterId());
        characterRaid.uncheckRaid();
        return characterRaid;
    }
}
