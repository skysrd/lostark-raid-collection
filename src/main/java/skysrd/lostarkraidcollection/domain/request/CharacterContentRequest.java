package skysrd.lostarkraidcollection.domain.request;

import lombok.Getter;

@Getter
public class CharacterContentRequest {
    private Long characterContentId;
    private Long characterId;
    private Long raidId;
}
