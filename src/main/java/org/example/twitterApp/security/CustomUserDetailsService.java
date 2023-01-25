package org.example.twitterApp.security;

import org.example.twitterApp.objectClassAndRepository.model.Role;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.repository.TwitterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TwitterUserRepository tUr;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TwitterUser tu = tUr.findByUsername(username);
        if (tu != null) {
            return new User(tu.getUsername(), tu.getPassword(), mapRolesToAuthorities(tu.getRoles()));
        } else {
            throw new UsernameNotFoundException("Username not found");
        }
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
