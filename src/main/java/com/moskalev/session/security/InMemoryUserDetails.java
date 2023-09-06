package com.moskalev.session.security;


import com.moskalev.session.dto.SessionUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InMemoryUserDetails implements UserDetailsService {

    private final Map<String, SessionUserDetails> users;

    public InMemoryUserDetails(Collection<SessionUserDetails> sessionUserDetails) {
        this.users = sessionUserDetails.stream().collect(Collectors.toMap(SessionUserDetails::getUsername, Function.identity()));
    }

    @Override
    public SessionUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SessionUserDetails user = this.users.get(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        return new SessionUserDetails(user.getUsername(), user.getMaximumMessage(),user.getMaximumSession(),user.getSessionTimeout());
    }
}
