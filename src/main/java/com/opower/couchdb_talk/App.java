package com.opower.couchdb_talk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    
    private static final String APP_CONTEXT = "applicationContext.xml";
    
    public static void main( String[] args ) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(APP_CONTEXT);
        
        Driver driver = (Driver)appContext.getBean("driver");
        driver.doStuff();
    }
}
