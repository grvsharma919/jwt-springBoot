package com.gaurav.efuel;

import com.gaurav.efuel.dao.entity.Role;
import com.gaurav.efuel.dao.entity.User;
import com.gaurav.efuel.dao.repository.UserRepository;
import com.gaurav.efuel.enums.RoleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        createAdmin();
        //userDetailService.writeDataToExcel();
    }

    /**
     * Use to create a user with role admin
     */
    private void createAdmin() {
        logger.info("user CREATE INIT");
        // create a user with below credential
        String name ="gaurav";
        String email = "admin@bblab.biz";
        String password = "Bblab@321";

        Optional<User> userOptional = userRepository.findByEmail(email);
        if(!userOptional.isPresent()) {
            User user = userRepository.save(User.builder()
                    .email(email)
                    .name(name)
                    .emailVerified(true)
                    .active(false)
                    .deleted(false)
                    .password(bCryptPasswordEncoder.encode(password))
                    .roles(Collections.singleton(Role.builder().roleType(RoleType.ROLE_ADMIN).build())).build());
            if (Optional.ofNullable(user).isPresent()) {
                logger.info("A new user has been created with username::{} & password:: {}", email, password);
            }
        }else
            logger.info("A User is already present with username:: {}", email);
    }
}
