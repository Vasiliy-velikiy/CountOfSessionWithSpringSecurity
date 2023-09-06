package com.moskalev.session.service.impl;


import com.moskalev.session.service.SessionService;
import com.moskalev.session.utils.SessionUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Enumeration;
import java.util.stream.Collectors;

import org.slf4j.Logger;


@Service
public class SessionServiceImpl implements SessionService {
    static Logger LOGGER = LoggerFactory.getLogger(SessionServiceImpl.class);

    public String checkCountOfRequest(ServletWebRequest request) {
        HttpServletRequest httpRequest = request.getRequest();
        HttpSession session = httpRequest.getSession();
        printSessionId(session.getId());
        SessionUtils.logRequest(request.getRequest());
        return SessionUtils.buildCountOfRequestMessage(session);
    }

    private void printSessionId(String id) {
        LOGGER.info("sessionId:" + id);
    }

    @Override
    public String checkPersonOfRequest(ServletWebRequest request) {
        HttpServletRequest httpRequest = request.getRequest();
        HttpSession session = httpRequest.getSession();
        setInvalidateInterval(session);
        printSessionId(session.getId());
        printAttributes(session.getAttributeNames());
        return SessionUtils.getPersonFromSession(session);
    }

    /**
     * setMaxInactiveInterval(int seconds): устанавливает интервал неактивности в секундах.
     * И если в течение этого интервала клиент был неактивен, то данные сессии данные удаляются.
     * По умолчанию максимальный интервал неактивности 1800 секунд.
     * Значение -1 указывает, что сессия удаляется только тогда, когда пользователь закрыл вкладку в браузере.
     */
    private void setInvalidateInterval(HttpSession session) {
        session.setMaxInactiveInterval(10);
    }

    private void printAttributes(Enumeration<String> attributeNames) {
        String attrs = "attrs:" + Collections.list(attributeNames).stream().collect(Collectors.joining(", "));
        System.out.println(attrs);
        LOGGER.info(attrs);
    }
}
