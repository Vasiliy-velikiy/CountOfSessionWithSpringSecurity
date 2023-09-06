package com.moskalev.session.controller.impl;

import com.moskalev.session.controller.ConverterController;
import com.moskalev.session.service.impl.ConverterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequiredArgsConstructor
@RequestMapping("/convert")
public class ConverterControllerImpl implements ConverterController {

    private final ConverterServiceImpl converterBean;

    @GetMapping
    public void processRequest(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        converterBean.processRequest(request, response);
    }
}
