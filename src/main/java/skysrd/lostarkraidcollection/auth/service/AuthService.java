package skysrd.lostarkraidcollection.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import skysrd.lostarkraidcollection.auth.dto.TokenDto;
import skysrd.lostarkraidcollection.auth.provider.JwtTokenProvider;
import skysrd.lostarkraidcollection.domain.entity.request.MemberRequest;
import skysrd.lostarkraidcollection.domain.entity.request.UserRequest;
import skysrd.lostarkraidcollection.repository.MemberRepository;

import java.sql.ResultSet;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;

    @Transactional
    public ResponseEntity<?> signup(MemberRequest memberRequest) {
        if(memberRepository.existsByUsername(memberRequest.getUsername())) {
            return;
        }
    }

    @Transactional
    public ResponseEntity<?> login(MemberRequest memberRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = memberRequest.toAuthentication();
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokenDto = jwtTokenProvider.generateTokenDto(authentication);
    }

    @Transactional
    public ResponseEntity<?> logout(MemberRequest memberRequest) {
        ;
    }
}
