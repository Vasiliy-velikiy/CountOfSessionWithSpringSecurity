package com.moskalev.session.service.impl;

import com.moskalev.session.service.ConverterService;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;


@Service
public class ConverterServiceImpl implements ConverterService {
private static final Double COURCE_YEN=138.41;

    /**
     * Обработка запросов как для <code>GET</code>,
     *    так и для <code>POST</code> методов HTTP.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Test Service </title>");
            out.println("</head>");
            out.println("<body>");
            Principal principal=request.getUserPrincipal();
            double result = dollarToYen();
            out.println("<h1>result of dollarToYen= "
                    + result + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            throw new ServletException(e);
        } finally {
            request.logout();
            out.close();
        }
    }

    private static double dollarToYen() {
        return COURCE_YEN;
    }
}
