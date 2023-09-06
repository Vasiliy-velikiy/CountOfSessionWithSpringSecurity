package com.moskalev.session.config;

import com.moskalev.session.dto.SessionUserDetails;
import com.moskalev.session.security.InMemoryUserDetails;
import com.moskalev.session.session.SessionUserProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;


import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {

   private final SessionUserProperties sessionUserProperties;

    @Bean
    public InMemoryUserDetails userDetailsService() {
        List<SessionUserDetails> users = this.sessionUserProperties.getUsers().stream()
                .map(user -> new SessionUserDetails(user.getUsername(), user.getMaximumMessage(), user.getMaximumSession(), user.getSessionTimeout()))
                .collect(Collectors.toList());
        return new InMemoryUserDetails(users);
    }
}
