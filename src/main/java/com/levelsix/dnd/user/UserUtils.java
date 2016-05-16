package com.levelsix.dnd.user;

import com.levelsix.dnd.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by cgaskill on 5/14/16.
 */
public class UserUtils {
    public static User getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof User) {
           return  (User) principal;
        }
        throw new IllegalStateException("principal must be an instance of User");
    }
}
