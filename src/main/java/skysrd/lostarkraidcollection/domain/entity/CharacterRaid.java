package skysrd.lostarkraidcollection.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "CHARACTER_RAID")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterRaid {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_raid_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id")
    private Character character;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raid_id")
    private Raid raid;

    @Column(name = "character_raid_status")
    private Boolean status;
}
