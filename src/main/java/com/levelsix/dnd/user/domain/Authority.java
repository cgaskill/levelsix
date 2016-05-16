package com.levelsix.dnd.user.domain;

import com.levelsix.dnd.user.AuthorityRole;
import com.levelsix.dnd.user.domain.User;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by cgaskill on 5/15/16.
 */
@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "authority")
    private String name;

    public Authority() {

    }

    public Authority(User user, AuthorityRole role) {
        this.name = role.name();
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
