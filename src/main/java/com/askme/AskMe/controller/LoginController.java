package com.askme.AskMe.controller;



import com.askme.AskMe.model.Client;
import com.askme.AskMe.security.request.AuthenticationRequest;
import com.askme.AskMe.security.response.AuthResponse;
import com.askme.AskMe.security.service.AuthenticationService;
import com.askme.AskMe.security.service.JWTService;
import com.askme.AskMe.services.ClientServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@AllArgsConstructor
public class LoginController {

    private final AuthenticationService authService;
    private final JWTService jwtService;
    private final ClientServices clientServices;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/api/get-me")
    public Client getMe(@RequestHeader(HttpHeaders.AUTHORIZATION) String header) {
        String token = header.substring(7);
        String username = jwtService.extractUsername(token);
        return clientServices.getClientByUsername(username);
    }
}
