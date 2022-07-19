package skysrd.lostarkraidcollection.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import skysrd.lostarkraidcollection.domain.entity.enumurated.Authority;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Authority authority;

}
