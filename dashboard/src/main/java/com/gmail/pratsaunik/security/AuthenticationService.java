package com.gmail.pratsaunik.security;

import com.gmail.pratsaunik.pojo.AppUser;
import com.gmail.pratsaunik.user.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service("authService")
public class AuthenticationService implements UserDetailsService {

    private static Logger log = Logger.getLogger("AuthenticationService");

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername() username=" + username);
        AppUser appUser = appUserRepository.findUserByLogin(username);

        if (appUser == null) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }

        return new User(appUser.getUsername(), appUser.getPassword(),  Set.of(new SimpleGrantedAuthority("ROLE_" + appUser.getRoleOfUser().getRoleName().name())));
    }
}