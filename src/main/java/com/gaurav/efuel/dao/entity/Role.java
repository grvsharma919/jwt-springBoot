package com.gaurav.efuel.dao.entity;

import com.gaurav.efuel.enums.RoleType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@Setter
@Getter
@Entity
@AllArgsConstructor
@Builder
@ToString
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
