package com.levelsix.dnd.player;

import java.util.List;

/**
 * Created by cgaskill on 5/14/16.
 */
public interface PlayerService {
    List<Character> getCharacters(Long userId);
}
