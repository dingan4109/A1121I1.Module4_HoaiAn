package spring_casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring_casestudy.entity.User;
import spring_casestudy.repository.UserRepo;
import spring_casestudy.repository.UserRoleRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserRoleRepo userRoleRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsernameContaining(username);
        if(user==null) {
            throw new UsernameNotFoundException("Username " + username + " does not exist!");
        }

        List<String> roles = userRoleRepo.findAllRoleByUsername(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for(String role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username,user.getPassword(),grantedAuthorities);
        return userDetails;

    }
}
