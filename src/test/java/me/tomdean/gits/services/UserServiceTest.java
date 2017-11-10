package me.tomdean.gits.services;

import java.util.Set;
import java.util.HashSet;
import me.tomdean.gits.models.Role;
import me.tomdean.gits.models.RoleType;
import me.tomdean.gits.models.User;
import me.tomdean.gits.GitsApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GitsApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    private static final String password = "password";
    private User savedUser;

    @Before
    public void setUp() {
        Role savedRole = roleService.findByRole(RoleType.USER.toString());

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(savedRole);

        savedUser = new User();
        savedUser.setPassword(password);
        savedUser.setUserName("john.doe");
        savedUser.setEmployeeNumber(112233);
        savedUser.setJobTitle("Some title");
        savedUser.setRoles(userRoles);

        userService.save(savedUser);
    }

    @After
    public void tearDown() {
        userService.delete(savedUser);
    }

    @Test
    public void shouldNotStorePlainTextPassword() throws Exception {
        assertThat(savedUser.getPassword(), is(not(password)));
    }

    @Test
    public void shouldFindUserById() throws Exception {
        User foundUser = userService.findById(savedUser.getId());
        assertThat(savedUser, is(foundUser));
    }

    @Test
    public void shouldFindUserByUserName() throws Exception {
        User foundUser = userService.findByUserName(savedUser.getUserName());
        assertThat(savedUser, is(foundUser));
    }
}
