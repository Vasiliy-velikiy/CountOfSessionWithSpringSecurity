package com.moskalev.session.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import java.net.http.HttpRequest;

@RequestMapping("/session")
public interface SessionController {

    String getCountOfRequest(ServletWebRequest request);
    String getPersonFromSession(ServletWebRequest request);
}
