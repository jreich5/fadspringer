package com.codeup.fadspringer.db;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final Users users;

    public UserDetailsLoader(Users users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = users.findByEmail(email); // only works if form has a "username" name attribute value
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + email);
        }

        return new UserWithRoles(user);
    }
}
