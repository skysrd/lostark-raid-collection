package skysrd.lostarkraidcollection.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import skysrd.lostarkraidcollection.domain.entity.Character;
import skysrd.lostarkraidcollection.domain.entity.CharacterContent;
import skysrd.lostarkraidcollection.domain.request.CharacterContentRequest;
import skysrd.lostarkraidcollection.repository.CharacterContentRepository;
import skysrd.lostarkraidcollection.repository.CharacterRepository;
import skysrd.lostarkraidcollection.repository.MemberRepository;
import skysrd.lostarkraidcollection.repository.ContentService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CharacterRaidService {
    private final CharacterContentRepository characterContentRepository;
    private final CharacterRepository characterRepository;
    private final MemberRepository memberRepository;
    private final ContentService raidRepository;

    public List<CharacterContent> characterRaids() {
        return characterContentRepository.findAll();
    }

    public List<CharacterContent> characterRaids(Character character) {
        return characterContentRepository.findAllByCharacter(character);
    }

    public CharacterContent createCharacterRaid(CharacterContentRequest characterRaidRequest) {
        CharacterContent characterContent = CharacterContent.builder()
                .character(characterRepository.findCharacterById(characterRaidRequest.getCharacterId()))
                .raid(raidRepository.findRaidById(characterRaidRequest.getRaidId()))
                .build();

        characterContentRepository.save(characterContent);
        return characterContent;

    }

    public CharacterContent checkRaid(CharacterContentRequest characterContentRequest) {
        CharacterContent characterContent = characterContentRepository.findById(
                        characterContentRequest.getCharacterContentId())
                .orElseThrow(()->new IllegalArgumentException("해당 정보가 없습니다."));
        characterContent.checkRaid();
        return characterContent;

    }

    public CharacterContent uncheckRaid(CharacterContentRequest characterContentRequest) {
        CharacterContent characterContent = characterContentRepository.findById(
                        characterContentRequest.getCharacterContentId())
                .orElseThrow(()->new IllegalArgumentException("해당 정보가 없습니다."));
        characterContent.uncheckRaid();
        return characterContent;
    }
}
