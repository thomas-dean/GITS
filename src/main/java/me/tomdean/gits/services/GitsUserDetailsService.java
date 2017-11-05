package me.tomdean.gits.services;

import me.tomdean.gits.models.Role;
import me.tomdean.gits.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("gitsUserDetailsService")
public class GitsUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = userService.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role role: user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }
        return authorities;
    }
}
