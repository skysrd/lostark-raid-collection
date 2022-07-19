package skysrd.lostarkraidcollection.domain.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String username;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder) {
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
