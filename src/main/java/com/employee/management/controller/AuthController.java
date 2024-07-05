package com.employee.management.controller;

import com.employee.management.entity.AuthenticationRequest;
import com.employee.management.service.CustomUserDetailsService;
import com.employee.management.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        logger.info("Inside Auth");
        String jwt = "";
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );


            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            logger.info("User Details: {} {}", authenticationRequest.getUsername(), authenticationRequest.getPassword());
            jwt = jwtUtil.generateToken(userDetails);
            logger.info("jwt {}", jwt);
        }catch (Exception e){
            logger.error("exception {}", e);
            e.printStackTrace();
        }

        return jwt;
    }
}