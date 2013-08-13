package org.thilina.examples.vaadinlogin;

import com.vaadin.Application;
import com.vaadin.service.ApplicationContext.TransactionListener;

import java.io.Serializable;
import java.util.Date;

/**
 * Vaadin login sample -  App Data class.
 * This class used to store data per user session.
 * <p/>
 * Author : Thilina Piyasundara
 * Date   : 6/21/12
 * Visit  : http://thilina.org
 */
public class AppData implements TransactionListener, Serializable {

    private String userData;
    private Application app;
    private static ThreadLocal<AppData> instance = new ThreadLocal<AppData>();

    public AppData(Application app) {

        System.out.println("creating a new session instance : " + new Date().toString());
        this.app = app;
        instance.set(this);
    }

    @Override
    public void transactionStart(Application application, Object transactionData) {

        System.out.println("A new transaction occurred : " + new Date().toString());
        if (this.app == application)
            instance.set(this);
    }

    @Override
    public void transactionEnd(Application application, Object transactionData) {

        System.out.println("Transaction end at : " + new Date().toString());
        if (this.app == application)
            instance.set(null);
    }

    public static String getUserData() {
        return instance.get().userData;
    }

    public static void setUserData(String userData) {
        instance.get().userData = userData;
    }
}