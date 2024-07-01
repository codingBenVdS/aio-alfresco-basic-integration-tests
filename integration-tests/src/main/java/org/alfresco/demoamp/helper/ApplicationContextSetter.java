package org.alfresco.demoamp.helper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextSetter implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextProvider.setApplicationContext(applicationContext);
    }
}
