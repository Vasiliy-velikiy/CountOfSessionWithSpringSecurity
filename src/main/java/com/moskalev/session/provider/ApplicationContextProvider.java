package com.moskalev.session.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


/**Класс для доступа к контексту спринга в классе не являющегося бином*/
@Component
public class ApplicationContextProvider {

    // Контекст Spring
    private static ApplicationContext ctx;

    @Autowired
    public ApplicationContextProvider(ApplicationContext applicationContext) {
        ApplicationContextProvider.ctx = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }
}
