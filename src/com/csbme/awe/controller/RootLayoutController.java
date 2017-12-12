package com.csbme.awe.controller;

import com.csbme.awe.MainApp;
import javafx.fxml.FXML;

public class RootLayoutController {

    // Reference to the main application
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleNew() {
        mainApp.getRecordData().clear();
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
}