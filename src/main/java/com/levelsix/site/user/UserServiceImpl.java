package com.levelsix.site.user;

import com.levelsix.site.user.domain.Authority;
import com.levelsix.site.user.domain.User;
import com.levelsix.site.user.domain.UserDto;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by cgaskill on 5/14/16.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthorityDao authorityDao;

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userDao.findOneByEmail(email));
    }

    @Override
    public Optional<User> getUserById(long id) {
        return Optional.ofNullable(userDao.findOne(id));
    }

    @Override
    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setName(userDto.getName());
        user.setEnabled(true);
        user = userDao.save(user);

        Authority authority = new Authority(user, AuthorityRole.PLAYER);
        authorityDao.save(authority);

        return user;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findOneByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("User with " + username + " does not exist.");
        }
        Hibernate.initialize(user.getAuthorities());
        return user;
    }
}