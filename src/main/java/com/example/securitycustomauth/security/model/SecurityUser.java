package com.example.securitycustomauth.security.model;

import com.example.securitycustomauth.entity.ApplicationUser;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import java.util.stream.Collectors;

@ToString
@RequiredArgsConstructor
public class SecurityUser implements UserDetails {
    private final ApplicationUser applicationUser;

    @Override
    public String getUsername() {
        return applicationUser.getLogin();
    }

    @Override
    public String getPassword() {
        return applicationUser.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return applicationUser.getRoles()
                .stream()
                .map(SecurityRole::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
