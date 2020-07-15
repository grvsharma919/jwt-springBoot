package com.gaurav.efuel.dao.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Setter
@Getter
@Entity
@AllArgsConstructor
@Builder
@ToString
public class TypeMeasurementUnit extends BaseEntity {

    @NotNull(message = "Company name can't not be Empty")
    @Column(nullable = false, unique = true)
    private String name ;

    @NotNull(message = "Company name can't not be Empty")
    @Column(nullable = false, unique = true)
    private String symbol ;
}
