package skysrd.lostarkraidcollection.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import skysrd.lostarkraidcollection.auth.dto.TokenDto;
import skysrd.lostarkraidcollection.auth.provider.JwtTokenProvider;
import skysrd.lostarkraidcollection.domain.entity.Member;
import skysrd.lostarkraidcollection.domain.entity.request.LoginRequest;
import skysrd.lostarkraidcollection.domain.entity.request.SignupRequest;
import skysrd.lostarkraidcollection.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;

    @Transactional
    public Long signup(SignupRequest signupRequest) {
        if(memberRepository.existsByUsername(signupRequest.getUsername())) {
            return 0L;
        }
        else {
            return memberRepository.save(
                    Member.builder()
                            .username(signupRequest.getUsername())
                            .password(signupRequest.getPassword())
                            .nickname(signupRequest.getNickname())
                            .build()
            ).getId();
        }
    }

    @Transactional
    public TokenDto login(LoginRequest memberRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = memberRequest.toAuthentication();
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokenDto = jwtTokenProvider.generateTokenDto(authentication);

        return tokenDto;
    }

//    @Transactional
//    public ResponseEntity<?> logout(LoginRequest memberRequest) {
//        ;
//    }
}
