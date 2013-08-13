package org.thilina.examples.vaadinlogin;

import com.vaadin.ui.*;

/**
 * Vaadin login sample -  Login window class.
 * <p/>
 * Author : Thilina Piyasundara
 * Date   : 6/21/12
 * Visit  : http://thilina.org
 */
public class LoginWindow extends VerticalLayout {

    public LoginWindow() {

        final LoginForm login = new LoginForm();
        login.addListener(new LoginForm.LoginListener() {
            public void onLogin(LoginForm.LoginEvent event) {

                String username = event.getLoginParameter("username");
                String password = event.getLoginParameter("password");

                if (username.equals("") || password.equals("")) {

                    getWindow().showNotification("Both fields are required.",
                            Window.Notification.TYPE_ERROR_MESSAGE);
                } else if ((username.equalsIgnoreCase("user") && password.equals("password"))) {

                    getWindow().showNotification("Welcome User : " + event.getLoginParameter("username"));
                    AppData.setUserData(username);
                    getApplication().getMainWindow().addComponent(new MainWindow());
                    getApplication().getMainWindow().removeComponent(LoginWindow.this);
                } else {

                    getWindow().showNotification("Check the user name and the password.",
                            Window.Notification.TYPE_ERROR_MESSAGE);
                }
            }
        });
        addComponent(login);
        login.setSizeUndefined();
        setComponentAlignment(login, Alignment.MIDDLE_CENTER);
    }
}
