package com.juarezmaria.appUtil.ComprasApp.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_role", uniqueConstraints = @UniqueConstraint(columnNames = {"role","username"}))
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "user_role_id", unique = true)
    @NotNull
    private Integer userRoleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    @NotBlank
    private User user;

    @Column(name = "role", length = 45)
    @NotBlank
    private  String role;

    public UserRole(User user, String role) {
        super();
        this.user = user;
        this.role = role;
    }

    public UserRole(){}

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
