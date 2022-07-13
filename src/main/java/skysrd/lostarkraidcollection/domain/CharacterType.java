package skysrd.lostarkraidcollection.domain;

import lombok.Getter;

@Getter
public enum CharacterType {
    WARLORD("WARLORD"), DESTROYER("DESTROYER");
    private final String code;

    CharacterType(String code) {
        this.code = code;
    }
}
