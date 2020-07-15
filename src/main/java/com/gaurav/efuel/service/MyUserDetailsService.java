package com.gaurav.efuel.service;

import com.gaurav.efuel.dao.entity.User;
import com.gaurav.efuel.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> byEmail = userRepository.findByEmail(email);
        byEmail.orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));
        return MyUserDetails.builder().user(byEmail.get()).build();
    }
}
