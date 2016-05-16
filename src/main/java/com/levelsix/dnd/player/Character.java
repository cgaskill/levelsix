package com.levelsix.dnd.player;

import com.levelsix.dnd.user.domain.User;

import javax.persistence.*;

/**
 * Created by cgaskill on 5/14/16.
 */
@Entity
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    User user;

    @Column(name = "name", nullable = false, unique = false)
    String name;

    @Column(name = "currentXp", nullable = false, unique = false)
    int currentXp;

    // TODO convert to an enum
    @Column(name = "race", nullable = false, unique = false)
    String race;

    // TODO convert to an enum
    @Column(name = "sex", nullable = false, unique = false)
    String sex;

    // TODO convert to an enum
    @Column(name = "class", nullable = false, unique = true)
    String characterClass;
}
