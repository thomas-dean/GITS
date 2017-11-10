package me.tomdean.gits.controllers;

import me.tomdean.gits.GitsApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GitsApplication.class)
public class AuthenticationControllerTest {
    @Autowired
    private WebApplicationContext context;

    @MockBean
    private UserDetailsService userDetailsServiceMock;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void shouldFetchLoginPage() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void shouldErrorOnBadAuth() throws Exception {
        when(userDetailsServiceMock.loadUserByUsername("john.doe"))
                .thenReturn(new User("john.doe", "password", new ArrayList<>()));

        mockMvc.perform(post("/login").with(csrf())
                .param("username", "john.doe")
                .param("password", "invalid"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/login?error"));
    }

    @Test
    public void shouldRedirectToRootAfterLogin() throws Exception {
        when(userDetailsServiceMock.loadUserByUsername("john.doe"))
                .thenReturn(new User("john.doe", "password", new ArrayList<>()));

        mockMvc.perform(post("/login").with(csrf())
                .param("username", "john.doe")
                .param("password", "password"))
                    .andExpect(status().isFound())
                    .andExpect(redirectedUrl("/"));
    }

    @Test
    public void shouldNotLoginWithoutCsrfToken() throws Exception {
        when(userDetailsServiceMock.loadUserByUsername("john.doe"))
                .thenReturn(new User("john.doe", "password", new ArrayList<>()));

        mockMvc.perform(post("/login")
                .param("username", "john.doe")
                .param("password", "password"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void shouldNotLoginWithInvalidCsrfToken() throws Exception {
        when(userDetailsServiceMock.loadUserByUsername("john.doe"))
                .thenReturn(new User("john.doe", "password", new ArrayList<>()));

        mockMvc.perform(post("/login").with(csrf().useInvalidToken())
                .param("username", "john.doe")
                .param("password", "password"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void shouldRedirectToLoginAfterLogout() throws Exception {
        mockMvc.perform(logout())
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/login?logout"));
    }
}