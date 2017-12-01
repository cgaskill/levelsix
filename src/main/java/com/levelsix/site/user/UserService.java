package com.levelsix.site.user;

import com.levelsix.site.user.domain.User;
import com.levelsix.site.user.domain.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

/**
 * Created by cgaskill on 5/14/16.
 */
public interface UserService extends UserDetailsService {
    User registerUser(UserDto userDto);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserById(long id);
}
