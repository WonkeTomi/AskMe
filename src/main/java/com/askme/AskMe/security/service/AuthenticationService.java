package com.askme.AskMe.security.service;

import com.askme.AskMe.model.Client;
import com.askme.AskMe.model.Role;
import com.askme.AskMe.repository.ClientRepository;
import com.askme.AskMe.security.request.AuthenticationRequest;
import com.askme.AskMe.security.request.RegisterRequest;
import com.askme.AskMe.security.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final ClientRepository clientRepository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {
        var user = Client.builder()
                .email(request.getEmail())
                .name(request.getName())
                .username(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        clientRepository.save(user);
        return "registration successfully";
    }

    public AuthResponse authenticate(AuthenticationRequest authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        UserDetails userDetails = clientRepository.findByUsername(authRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("There are no such username"));

        var jwtToken = jwtService.generateToken(userDetails);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
