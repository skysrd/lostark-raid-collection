package skysrd.lostarkraidcollection.domain.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import skysrd.lostarkraidcollection.domain.entity.enumurated.Authority;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member (String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }
}
