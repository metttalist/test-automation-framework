package com.igor.khorev.qa.utility;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by metttalist on 11/29/18.
 */
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext appContext;

    /**
     * Returns Spring's current application context.
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return appContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }
}
