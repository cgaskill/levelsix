package com.levelsix.dnd.user;

import com.levelsix.dnd.user.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by cgaskill on 5/14/16.
 */
public interface UserDao extends CrudRepository<User, Long> {
    User findOneByEmail(String email);
}
