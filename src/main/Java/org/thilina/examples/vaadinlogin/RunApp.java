package org.thilina.examples.vaadinlogin;

import com.vaadin.Application;
import com.vaadin.ui.Window;

/**
 * Vaadin login sample - Initial RunApp class extended from
 * Application class.
 * <p/>
 * Author : Thilina Piyasundara
 * Date   : 6/21/12
 * Visit  : http://thilina.org
 */
public class RunApp extends Application {

    // Initialize session
    final AppData sessionData = new AppData(this);

    /**
     * Init is invoked on application load (when a user accesses the application
     * for the first time).
     */
    @Override
    public void init() {

        // Adding the transaction listener.
        getContext().addTransactionListener(sessionData);
        Window mainWindow = new Window("Title Text");
        setMainWindow(mainWindow);

        mainWindow.addComponent(new LoginWindow());
        System.out.println("Setting the main window as login.");
        mainWindow.showNotification("Use \"user\" as the user name and \"password\" as the password.",
                Window.Notification.TYPE_ERROR_MESSAGE);
    }
}
