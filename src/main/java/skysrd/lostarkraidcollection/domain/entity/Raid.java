package skysrd.lostarkraidcollection.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "RAID")
public class Raid {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raid_id")
    private Long id;

    @Column(name = "raid_name")
    private String name;

    @Column("raid_start_level")
    private int startLevel;

    @Column("raid_end_level")
    private int endLevel;

    @Column("raid_gold")
    private int gold;
}
