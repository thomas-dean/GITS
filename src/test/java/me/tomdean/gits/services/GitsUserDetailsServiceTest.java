package me.tomdean.gits.services;

import me.tomdean.gits.GitsApplication;
import me.tomdean.gits.models.Role;
import me.tomdean.gits.models.RoleType;
import me.tomdean.gits.models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GitsApplication.class)
public class GitsUserDetailsServiceTest {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    UserDetailsService gitsUserDetailsService;

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
    public void shouldThrowOnUnknownUser() throws Exception {
        try {
            gitsUserDetailsService.loadUserByUsername("bogus_user");
            fail("loadUserByUsername should not have found user 'bogus_user'");
        } catch (UsernameNotFoundException e) { }
    }

    @Test
    public void shouldFetchUserInformation() throws Exception {
        UserDetails userDetails = gitsUserDetailsService.loadUserByUsername("john.doe");
        assertThat(userDetails.getUsername(), is("john.doe"));
    }

    @Test
    public void shouldReturnEnabledUser() throws Exception {
        UserDetails userDetails = gitsUserDetailsService.loadUserByUsername("john.doe");
        assertThat(userDetails.isEnabled(), is(true));
    }

    @Test
    public void shouldReturnNonLockedOutUser() throws Exception {
        UserDetails userDetails = gitsUserDetailsService.loadUserByUsername("john.doe");
        assertThat(userDetails.isAccountNonLocked(), is(true));
    }

    @Test
    public void shouldReturnNonExpiredUser() throws Exception {
        UserDetails userDetails = gitsUserDetailsService.loadUserByUsername("john.doe");
        assertThat(userDetails.isAccountNonExpired(), is(true));
    }

    @Test
    public void shouldReturnNonExpiredCredentialUser() throws Exception {
        UserDetails userDetails = gitsUserDetailsService.loadUserByUsername("john.doe");
        assertThat(userDetails.isCredentialsNonExpired(), is(true));
    }

    @Test
    public void shouldFetchAuthorities() throws Exception {
        UserDetails userDetails = gitsUserDetailsService.loadUserByUsername("john.doe");
        assertThat(userDetails.getAuthorities().size(), is(1));
        assertEquals(userDetails.getAuthorities().toArray()[0], new SimpleGrantedAuthority("ROLE_USER"));
    }
}