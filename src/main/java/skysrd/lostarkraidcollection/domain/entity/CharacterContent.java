package skysrd.lostarkraidcollection.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "CHARACTER_CONTENT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterContent extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_content_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id")
    private Character character;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    private Raid raid;

    @Column(name = "is_done")
    private Boolean status;

    @Builder
    public CharacterContent(Character character, Raid raid) {
        this.character=character;
        this.raid=raid;
        this.status=false;
    }

    public void checkRaid() {
        this.status=true;
    }

    public void uncheckRaid() {
        this.status=false;
    }
}
