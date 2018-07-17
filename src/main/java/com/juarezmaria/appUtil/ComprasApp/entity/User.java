package com.juarezmaria.appUtil.ComprasApp.entity;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username", unique = true, length = 45)
    @NotBlank
    private String userName;

    @Column(name = "password", length = 60)
    @NotBlank
    private String password;

    @Column(name = "enabled")
    @NotBlank
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRole> userRole = new HashSet<UserRole>();

    public User(String userName, String password, boolean enabled) {
        super();
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String userName, String password, boolean enabled, Set<UserRole> userRole) {
        super();
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.userRole = userRole;
    }

    public User(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }
}
