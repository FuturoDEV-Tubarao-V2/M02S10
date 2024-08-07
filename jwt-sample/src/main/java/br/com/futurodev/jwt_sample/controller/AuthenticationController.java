package br.com.futurodev.jwt_sample.controller;

import br.com.futurodev.jwt_sample.model.transport.LoginForm;
import br.com.futurodev.jwt_sample.model.transport.TokenDTO;
import br.com.futurodev.jwt_sample.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginForm form) {
        TokenDTO response = this.authenticationService.login(form);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<TokenDTO> refreshToken(@RequestHeader("Authorization") String refreshToken) {
        TokenDTO response = this.authenticationService.refreshToken(refreshToken);
        return ResponseEntity.ok(response);
    }
}
