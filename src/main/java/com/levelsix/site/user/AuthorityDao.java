package com.levelsix.site.user;

import com.levelsix.site.user.domain.Authority;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by cgaskill on 5/15/16.
 */
public interface AuthorityDao extends CrudRepository<Authority, Long> {

}
