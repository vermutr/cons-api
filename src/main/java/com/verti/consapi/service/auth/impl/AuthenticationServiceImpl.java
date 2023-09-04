package com.verti.consapi.service.auth.impl;

import com.verti.consapi.config.security.JwtService;
import com.verti.consapi.controller.dto.auth.AuthenticationRequest;
import com.verti.consapi.controller.dto.auth.AuthenticationResponse;
import com.verti.consapi.controller.dto.auth.RegisterRequest;
import com.verti.consapi.model.Customer;
import com.verti.consapi.model.enumeration.Role;
import com.verti.consapi.service.auth.AuthenticationService;
import com.verti.consapi.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final CustomerService customersService;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    @Override
    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        Customer customers = Customer
                .builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        customersService.saveCustomer(customers);

        String jwtToken = jwtService.generateToken(customers);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
                  request.getEmail(),
                  request.getPassword()
          )
        );

        Customer customers = customersService.getCustomerByEmail(request.getEmail());
        String jwtToken = jwtService.generateToken(customers);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
