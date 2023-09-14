package com.br.budgetbuddy.user.service;

import com.br.budgetbuddy.user.dto.UserRegisterDto;
import io.micrometer.common.util.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class UserServiceDbIntegrationTest {

    private UserService userService;

    @Autowired
    public UserServiceDbIntegrationTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    void testFindByUsernameWhereUsernameDoesNotExist() {
        UserDetails user = userService.findByUsername("username");
        assertNull(user, "it should null");
    }

    @Test
    void testFindByUsernameWhereUsernameDoesExist() {
        UserDetails user = userService.findByUsername("user.name");
        assertNotNull(user, "shouldn't be null");
    }

    @Test
    void testRegisterWithoutAnyAttributeMatching() {
        UUID uuid = userService.register(new UserRegisterDto("steve.oak", "S3(ure_p4ssw0rd", "email@pmail.com"));
        assertTrue(StringUtils.isNotBlank(uuid.toString()), "it should be true");
    }

    @Test
    void testRegisterWithoutUsernameAttributeMatching() {
        UserRegisterDto user = new UserRegisterDto("steve.oak", "S3(ure_p4ssw0rd", "email@ymail.com");
        try {
            userService.register(user);
            fail("should have thrown an exception");
        } catch (DataIntegrityViolationException e) {
            assertTrue(e.getCause().toString().contains("UNIQUE_USERNAME"));
        }
    }

    @Test
    void testRegisterWithoutEmailAttributeMatching() {
        UserRegisterDto user = new UserRegisterDto("sasha.oak", "S3(ure_p4ssw0rd", "email@pmail.com");
        try {
            userService.register(user);
            fail("should have thrown an exception");
        } catch (DataIntegrityViolationException e) {
            assertTrue(e.getCause().toString().contains("UNIQUE_EMAIL"));
        }
    }
}