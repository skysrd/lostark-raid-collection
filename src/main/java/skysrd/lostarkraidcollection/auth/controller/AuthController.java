package skysrd.lostarkraidcollection.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skysrd.lostarkraidcollection.auth.service.AuthService;
import skysrd.lostarkraidcollection.domain.entity.request.LoginRequest;
import skysrd.lostarkraidcollection.domain.entity.request.SignupRequest;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(authService.signup(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest memberRequest) {
        return ResponseEntity.ok(authService.login(memberRequest));
    }

//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(@RequestBody LoginRequest memberRequest) {
//        return ResponseEntity.ok(authService.logout(memberRequest));
//    }
}
