package org.mobileOp.ioc;

import org.mobileOp.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring IoC Container wrapper.
 */
public class Container {
    private final ApplicationContext context;

    public Container() {
        this.context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    public Container(ApplicationContext context) {
        this.context = context;
    }

    public <T> T get(Class<T> clazz) {
        return context.getBean(clazz);
    }
}
