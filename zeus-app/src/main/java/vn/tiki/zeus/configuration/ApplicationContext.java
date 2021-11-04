package vn.tiki.zeus.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContext implements ApplicationContextAware {

    private static org.springframework.context.ApplicationContext context;

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext context) throws BeansException {
        ApplicationContext.context = context;
    }

    /**
     * Returns the Spring managed bean instance of the given class type if it exists.
     * Returns null otherwise.
     *
     * @param beanClass
     * @return
     */
    public static <T extends Object> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
}
