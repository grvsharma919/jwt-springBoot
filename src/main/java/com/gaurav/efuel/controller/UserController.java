package com.gaurav.efuel.controller;

import com.gaurav.efuel.constant.ApiConstants;
import com.gaurav.efuel.dao.entity.User;
import com.gaurav.efuel.response.AuthenticationDto;
import com.gaurav.efuel.service.UserAuthenticationService;
import com.gaurav.efuel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiConstants.API_V1)
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthenticationDto loginDto, BindingResult bindingResult) throws AuthenticationException {
        return userAuthenticationService.login(loginDto.getEmail(), loginDto.getPassword(), bindingResult);
    }

    @PostMapping(value = "/user")
    public ResponseEntity createCompany(@RequestBody User user){

        return userService.createUser(user);

    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity getCompanyById(@PathVariable long id){

        return userService.getUserById(id);

    }

    @PatchMapping(value = "/user")
    public ResponseEntity updateCompany(@RequestBody User user){

        return userService.updateUser(user);

    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity deleteUserById(@PathVariable long id){

        return userService.deleteUserById(id);

    }

    @GetMapping(value = "/user")
    public ResponseEntity<?> listAllUsers(@RequestParam int page, @RequestParam int size){
        return userService.listAllUsers(page,size);
    }
}
