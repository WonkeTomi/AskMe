package com.askme.AskMe.security.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationRequest {
    private final String username;
    private final String password;
}
