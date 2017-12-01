package com.levelsix.site.user;

import com.levelsix.site.user.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by cgaskill on 5/14/16.
 */
public interface UserDao extends CrudRepository<User, Long> {
    User findOneByEmail(String email);
}
