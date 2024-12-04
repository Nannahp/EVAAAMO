package com.example.evaaamo.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
//Named the table something else cause h2 already has user as default
@Table(name = "user_account")

//UserDetail interface used to load details for athentication
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;  //We use this as the username
    }

    //Securitys own UserDetails interface methods
    //Users account doesnt expire
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //Users account isnt locked
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //Users password doesnt expire
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //Users account is enabled and can be used
    @Override
    public boolean isEnabled() {
        return true;
    }

    //Needs to be there for UserDetails to work
    //Gets the roles/authorties - but we only have one user so no roles. Later on it could be fx admin
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();  //No roles/authorities for now
    }
}
