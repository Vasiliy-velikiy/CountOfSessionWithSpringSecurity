package com.moskalev.session.controller.impl;

import com.moskalev.session.controller.SessionController;
import com.moskalev.session.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;


@RestController
@RequiredArgsConstructor
public class SessionControllerImpl implements SessionController {

    private final SessionService sessionService;

    @GetMapping("/get")
    @Override
    public String getCountOfRequest(ServletWebRequest request) {
        return sessionService.checkCountOfRequest(request);
    }

    @GetMapping("/getPerson")
    @Override
    public String getPersonFromSession(ServletWebRequest request) {
        return sessionService.checkPersonOfRequest(request);
    }
}
