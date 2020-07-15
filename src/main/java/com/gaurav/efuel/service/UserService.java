package com.gaurav.efuel.service;

import com.gaurav.efuel.dao.entity.User;
import com.gaurav.efuel.dao.repository.UserRepository;
import com.gaurav.efuel.response.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.gaurav.efuel.constant.Messages.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ResponseEntity createUser(User user) {
        try {
            userRepository.save(user);
            return ResponseHandler.generateResponse(HttpStatus.OK, true, SUCCESS,
                    null, null);

        }catch (Exception e){
            logger.info("Exception occurred::createUser ", e.getMessage());
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,false,USER_DETAIL_NOT_FOUND,null,null);
        }
    }

    public ResponseEntity getUserById(long id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (!user.isPresent()) {
                return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, USER_DETAIL_NOT_FOUND,
                        null, null);
            }
            return ResponseHandler.generateResponse(HttpStatus.OK, true, SUCCESS,
                    user.get(), null);
        }catch (Exception e){
            logger.info("Exception occurred::getUserById ", e.getMessage());
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR,false,ERROR,null,null);
        }
    }

    public ResponseEntity updateUser(User user){
        try {
            userRepository.save(user);
            return ResponseHandler.generateResponse(HttpStatus.OK, true, SUCCESS,
                    null, null);

        }catch (Exception e){
            logger.info("Exception occurred::updateUser ", e.getMessage());
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,false,USER_DETAIL_NOT_FOUND,null,null);
        }
    }

    public ResponseEntity deleteUserById(long id){
        try {
            userRepository.deleteById(id);
            return ResponseHandler.generateResponse(HttpStatus.OK, true, SUCCESS,
                    null, null);
        }catch (Exception e){
            logger.info("Exception occurred::deleteUserById ", e.getMessage());
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,false,ERROR,null,null);
        }
    }

    public ResponseEntity<?> listAllUsers(int page, int size){
        try {
            Page<User> users = userRepository.findAll(PageRequest.of(page-1, size, Sort.by("createdDate").descending()));
            Map<String, Object> map = new HashMap<>();
            map.put("count", users.getTotalElements());
            map.put("data", users.get().collect(Collectors.toList()));
            return ResponseHandler.generateResponse(HttpStatus.OK, true, SUCCESS, map, null);
        }catch (Exception e){
            logger.info("Exception occurred::listAllUsers ", e.getMessage());
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,false,ERROR,null,null);
        }
    }
}
