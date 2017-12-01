package com.levelsix.site.user;

import com.levelsix.site.user.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by cgaskill on 5/14/16.
 */
@Controller
public class UserController {

    @Autowired
    protected UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/signup")
    public String signup(@ModelAttribute("userDto") UserDto userDto,
                         Model model) {
        model.addAttribute("userDto", userDto);
        return "/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupSubmit(@ModelAttribute("userDto") @Valid UserDto userDto,
                               BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "redirect:/signup";
        }
        if(userService.getUserByEmail(userDto.getEmail()).isPresent()) {
            bindingResult.reject("email", "existing.email");
            return "redirect:/signup";
        }
        userService.registerUser(userDto);
        // TODO login the user
        return "redirect:/login";
    }

}
