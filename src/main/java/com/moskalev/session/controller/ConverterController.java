package com.moskalev.session.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ConverterController {
    void processRequest(HttpServletRequest request,
                        HttpServletResponse response) throws Exception;
}
