package skysrd.lostarkraidcollection.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CONTENT")
public class Raid extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long id;

    @Column(name = "content_name")
    private String name;

    @Column(name = "content_min_level")
    private int minLevel;

    @Column(name = "content_max_level")
    private int maxLevel;

    @Column(name = "content_reward")
    private int reward;
}
