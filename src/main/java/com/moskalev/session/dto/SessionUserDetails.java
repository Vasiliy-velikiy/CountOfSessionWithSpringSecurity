package com.moskalev.session.dto;

import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.time.Duration;


public class SessionUserDetails extends User {
    @Getter
    private final int maximumMessage;
    @Getter
    private final int maximumSession;
    @Getter
    private final Duration sessionTimeout;

    public SessionUserDetails(String username, int maximumMessage, int maximumSession, Duration sessionTimeout) {
        super(username, "{noop}" + username, AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.maximumMessage = maximumMessage;
        this.maximumSession=maximumSession;
        this.sessionTimeout=sessionTimeout;
    }
}
