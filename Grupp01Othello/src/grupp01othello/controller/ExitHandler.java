/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author optimusprime (Elvir)
 */
public class ExitHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        Platform.exit();
        System.exit(0);
    }

    /**
     * Stänger av programmet utan att det
     * behöver ske ett event.
     */
    public void exit() {

        Platform.exit();
        System.exit(0);
    }

}
