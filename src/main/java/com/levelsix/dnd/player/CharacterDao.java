package com.levelsix.dnd.player;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by cgaskill on 5/14/16.
 */
public interface CharacterDao extends CrudRepository<Character, Long> {
//    List<Character> findByUserId(Long userId);
}
