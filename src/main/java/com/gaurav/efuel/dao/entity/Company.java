package com.gaurav.efuel.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@AllArgsConstructor
@Builder
@ToString
public class Company extends BaseEntity {

    @NotNull(message = "Company name can't not be Empty")
    @Column(nullable = false, unique = true)
    private String name ;

    @NotNull(message = "Email can't not be null")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$", message = "Please enter a valid email address.")
    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne
    private TypeMeasurementUnit typeMeasurementUnit;

    @OneToOne
    private  UserRole userRole;



}
