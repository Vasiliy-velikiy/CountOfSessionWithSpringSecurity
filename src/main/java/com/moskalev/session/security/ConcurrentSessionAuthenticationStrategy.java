package com.moskalev.session.security;

import com.moskalev.session.config.BeanConfig;
import com.moskalev.session.dto.SessionUserDetails;
import com.moskalev.session.provider.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;

public class ConcurrentSessionAuthenticationStrategy extends ConcurrentSessionControlAuthenticationStrategy {

    private final ApplicationContext ctx;

    public ConcurrentSessionAuthenticationStrategy(SessionRegistry sessionRegistry) {
        super(sessionRegistry);
        setExceptionIfMaximumExceeded(true);
        ctx = ApplicationContextProvider.getApplicationContext();
    }

    @Override
    protected int getMaximumSessionsForThisUser(Authentication authentication) {
        InMemoryUserDetails service = ctx.getBean(InMemoryUserDetails.class);
        SessionUserDetails user = service.loadUserByUsername(authentication.getName());
        return user.getMaximumSession();

    }


}
