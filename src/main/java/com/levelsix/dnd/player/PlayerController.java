package com.levelsix.dnd.player;

import com.levelsix.dnd.player.domain.CharacterDto;
import com.levelsix.dnd.user.domain.User;
import com.levelsix.dnd.user.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cgaskill on 5/14/16.
 */
@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @RequestMapping
    public String playerHome(Model model) {
        User user = UserUtils.getUser();

        model.addAttribute("characters", playerService.getCharacters(user.getId()));

        return "playerHome";
    }

    @RequestMapping(value = "/character", method = RequestMethod.POST)
    public String addCharacter(Model model, @ModelAttribute("characterDto") CharacterDto characterDto) {
        // Create a new character object
        return "redirect:/player";
    }
}
