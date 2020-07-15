package com.gaurav.efuel.dao.entity;

import com.gaurav.efuel.enums.TokenType;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class VerificationToken {

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    private String token;

    private TokenType tokenType;

    @Column(nullable = false)
    private boolean deleted;
}
