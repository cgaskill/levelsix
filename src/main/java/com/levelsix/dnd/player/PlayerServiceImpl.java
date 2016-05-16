package com.levelsix.dnd.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cgaskill on 5/14/16.
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    protected CharacterDao characterDao;

    @Override
    public List<Character> getCharacters(Long userId) {
//        return characterDao.findByUserId(userId);
        return null;
    }

}
