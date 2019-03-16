package com.authorization.configuration.boot;

import com.authorization.repository.UserRepository;
import com.authorization.model.User;
import com.authorization.model.UserRole;
import com.authorization.repository.UserRolesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CreateDefaultUserListener implements ApplicationListener<ContextRefreshedEvent> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //Creating User
        logger.info("Creating user with role USER");
        User user = new User();
        user.setEmail("test@test.com");
        user.setEnabled(1);
        user.setUserName("user");
        user.setPassword("12345");
        userRepository.save(user);

        UserRole role = new UserRole();
        role.setRole("ROLE_USER");
        role.setUserId(user.getId());
        userRolesRepository.save(role);

        //Creating Admin
        logger.info("Creating user with role ADMIN");
        user = new User();
        user.setEmail("test@test.com");
        user.setEnabled(1);
        user.setUserName("admin");
        user.setPassword("12345");
        userRepository.save(user);

        role = new UserRole();
        role.setRole("ROLE_ADMIN");
        role.setUserId(user.getId());
        userRolesRepository.save(role);
    }
}
