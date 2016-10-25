package com.dms.domain.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "AUTHORITIES")
public class Authorities extends Indentity implements GrantedAuthority {

    @Column(name = "authority")
    private String authority;

    @ManyToMany
    private Set<User> users;

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
