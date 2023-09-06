package com.moskalev.session.utils;

import com.moskalev.session.dto.SessionUserDetails;
import com.moskalev.session.dto.redis.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;


//@Slf4j
public class SessionUtils {
    public static final String MESSAGE = "Client send count of request: ";
    public static final String MESSAGE_COUNT = "count";
    static Logger LOGGER = LoggerFactory.getLogger(SessionUtils.class);

    public static String getPersonFromSession(HttpSession session) {
        Person person = (Person) session.getAttribute("person");
        if (person == null) {
            person = new Person("Tom", 34);
            session.setAttribute("person", person);
            return "Session data are set";
        } else {
            return buildPersonMessage(session, person);
        }
    }

    public static void setSessionCount(HttpSession session, Integer count) {
        session.setAttribute(MESSAGE_COUNT, count);
    }

    public static Integer getSessionCount(HttpSession session) {
        Integer count = (Integer) session.getAttribute(MESSAGE_COUNT);
        return Objects.requireNonNullElse(count, 0) + 1;
    }

    public static String buildPersonMessage(HttpSession session, Person person) {
        Integer count = getSessionCount(session);
        String answer = person.toString() + MESSAGE + count;
        setSessionCount(session, count);
        return answer;
    }

    public static String buildCountOfRequestMessage(HttpSession session) {
        Integer count = getSessionCount(session);
        SessionUtils.setSessionCount(session, count);
        return SessionUtils.MESSAGE + count.toString();
    }


    public static void logRequest(HttpServletRequest request) {
      //  SessionUserDetails user=getUser(request);
    //    HttpSession session=request.getSession(false);
//        if (session ==null)
//            LOGGER.info("session is null");
//        Duration sessionLifetime=Duration.ofSeconds(session.getLastAccessedTime()-session.getCreationTime());
//        Duration sessionTimeout=user.getSessionTimeout();
//        LOGGER.info("session sessionLifetime{} sessionTimeout {}",sessionLifetime.toString(),sessionTimeout.toString());
    }

    private static SessionUserDetails getUser(HttpServletRequest request) {
        return (SessionUserDetails)((UsernamePasswordAuthenticationToken)request.getUserPrincipal()).getPrincipal();
    }
}
