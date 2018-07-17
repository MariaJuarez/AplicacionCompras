package com.juarezmaria.appUtil.ComprasApp.service;

import com.juarezmaria.appUtil.ComprasApp.entity.UserRole;
import com.juarezmaria.appUtil.ComprasApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.juarezmaria.appUtil.ComprasApp.entity.User user = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
        return null;
    }

    private User buildUser(com.juarezmaria.appUtil.ComprasApp.entity.User user, List<GrantedAuthority> authorities){
        return new User(user.getUserName(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles){
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        for (UserRole userRole: userRoles) {
            auths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return new ArrayList<GrantedAuthority>(auths);
    }

}
