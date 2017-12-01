package com.levelsix.site.user;

import com.levelsix.site.user.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;

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
