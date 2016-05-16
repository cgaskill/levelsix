package com.levelsix.dnd.user;

import com.levelsix.dnd.user.domain.Authority;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by cgaskill on 5/15/16.
 */
public interface AuthorityDao extends CrudRepository<Authority, Long> {

}
