package com.gaurav.efuel.service;

import com.gaurav.efuel.config.security.AuthToken;
import com.gaurav.efuel.config.security.TokenProvider;
import com.gaurav.efuel.response.ResponseHandler;
import com.gaurav.efuel.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
@Service
public class UserAuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    public ResponseEntity login(String email, String password, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.printf("inside hasErrors");
            return ResponseHandler.generateResponse(
                    HttpStatus.BAD_REQUEST, false, null, null,
                    ResponseHandler.getFieldErrorResponse(bindingResult));
        }
        final Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));
        } catch (BadCredentialsException e) {
            System.out.println(e);
            return ResponseHandler
                    .generateResponse(HttpStatus.BAD_REQUEST, false,
                            "Incorrect email or password", null, null);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if (!CommonUtils.getLoggedIn().isEmailVerified())
            return
                    ResponseHandler
                            .generateResponse(HttpStatus.BAD_REQUEST, false,
                                    "Please verify your email address!", null, null);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }
}
