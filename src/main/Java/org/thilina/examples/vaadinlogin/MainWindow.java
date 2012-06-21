package org.thilina.examples.vaadinlogin;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;


/**
 * Vaadin login sample -  Main window class.
 * <p/>
 * Author : Thilina Piyasundara
 * Date   : 6/21/12
 * Visit  : http://thilina.org
 */
public class MainWindow extends VerticalLayout {

    public MainWindow() {

        // Creating the header
        HorizontalLayout header = new HorizontalLayout();
        header.setWidth(940, Sizeable.UNITS_PIXELS);

        header.setMargin(true);

        VerticalLayout logoPanel = new VerticalLayout();

        Label logo = new Label("Your Logo");
        logoPanel.addComponent(logo);

        Label h2Header = new Label();
        h2Header.setContentMode(Label.CONTENT_XHTML);
        h2Header.setStyleName(Reindeer.LABEL_H2);
        h2Header.setCaption("Header");
        logoPanel.addComponent(h2Header);
        logoPanel.setComponentAlignment(h2Header, Alignment.MIDDLE_LEFT);
        header.addComponent(logoPanel);

        VerticalLayout logoutPanel = new VerticalLayout();
        Label message = new Label("Welcome, " + AppData.getUserData());
        Button logoutBtn = new Button("Logout",
                new Button.ClickListener() {
                    // inline click-listener
                    public void buttonClick(Button.ClickEvent event) {
                        getApplication().close();
                    }
                });
        message.setSizeUndefined();
        message.setStyleName(Reindeer.LABEL_SMALL);
        logoutBtn.setStyleName(Reindeer.BUTTON_SMALL);
        logoutPanel.addComponent(message);
        logoutPanel.addComponent(logoutBtn);
        logoutPanel.setSizeUndefined();
        header.addComponent(logoutPanel);
        header.setComponentAlignment(logoutPanel, Alignment.BOTTOM_RIGHT);


        // Creating the body
        HorizontalLayout body = new HorizontalLayout();
        body.setWidth(940, Sizeable.UNITS_PIXELS);
        body.setMargin(true);
        body.addComponent(new Label("Body section items will come here. " +
                "Use multiple browsers to check the session management."));


        // Creating the footer
        VerticalLayout footer = new VerticalLayout();
        footer.setWidth(940, Sizeable.UNITS_PIXELS);
        footer.setMargin(true);
        Label copyRights = new Label();
        copyRights.setContentMode(Label.CONTENT_XHTML);
        copyRights.setCaption("Secure and redundent data backup system \u00A9  2012. All rights reserved.");
        footer.addComponent(copyRights);
        footer.setComponentAlignment(copyRights, Alignment.MIDDLE_CENTER);

        addComponent(header);
        addComponent(body);
        addComponent(footer);

        setComponentAlignment(header, Alignment.MIDDLE_CENTER);
        setComponentAlignment(body, Alignment.MIDDLE_CENTER);
        setComponentAlignment(footer, Alignment.MIDDLE_CENTER);
    }
}
