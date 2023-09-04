package com.verti.consapi.service.auth;


import com.verti.consapi.controller.dto.auth.AuthenticationRequest;
import com.verti.consapi.controller.dto.auth.AuthenticationResponse;
import com.verti.consapi.controller.dto.auth.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

}
