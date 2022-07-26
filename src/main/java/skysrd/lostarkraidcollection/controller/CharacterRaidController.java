package skysrd.lostarkraidcollection.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skysrd.lostarkraidcollection.domain.request.CharacterContentRequest;
import skysrd.lostarkraidcollection.service.CharacterRaidService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/characterRaid")
public class CharacterRaidController {
    private final CharacterRaidService characterRaidService;

    @GetMapping("/")
    public ResponseEntity<?> characterRaids() {
        return ResponseEntity.ok(characterRaidService.characterRaids());
    }

    @PostMapping("/")
    public ResponseEntity<?> characterRaid(@RequestBody @Valid CharacterContentRequest characterRaidRequest) {
        return ResponseEntity.ok(characterRaidService.createCharacterRaid(characterRaidRequest));
    }

    @PostMapping("/check")
    public ResponseEntity<?> checkRaid(@RequestBody @Valid CharacterContentRequest characterRaidRequest) {
        characterRaidService.checkRaid(characterRaidRequest);
        return ResponseEntity.ok("checked successful");
    }

    @PostMapping("/uncheck")
    public ResponseEntity<?> uncheckRaid(@RequestBody @Valid CharacterContentRequest characterRaidRequest) {
        characterRaidService.uncheckRaid(characterRaidRequest);
        return ResponseEntity.ok("unchecked successful");
    }

}
