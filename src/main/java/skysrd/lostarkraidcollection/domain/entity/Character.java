package skysrd.lostarkraidcollection.domain.entity;

import lombok.AccessLevel;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import skysrd.lostarkraidcollection.domain.CharacterType;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "CHATACTER")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Character {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User parentUser;

    @Column(name = "character_name")
    private String name;

    @Column(name = "character_level")
    private double level;

    @Column(name = "character_type")
    private String type;
}
