package com.moskalev.session.service;

import org.springframework.web.context.request.ServletWebRequest;

import java.net.http.HttpRequest;

public interface SessionService {

    String checkCountOfRequest(ServletWebRequest request);

    String checkPersonOfRequest(ServletWebRequest request);
}
