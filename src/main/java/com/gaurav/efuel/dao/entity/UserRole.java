package com.gaurav.efuel.dao.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@AllArgsConstructor
@Builder
@ToString
public class UserRole extends BaseEntity{

    @NotNull(message = "Please enter your User Role")
    @Column(nullable = false)
    private String userRoleType;
}
