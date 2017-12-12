package com.csbme.awe.controller;

import com.csbme.awe.MainApp;
import com.csbme.awe.model.Record;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.text.DecimalFormat;

public class RecordOverviewController {
    @FXML
    private TableView<Record> recordTable;
    @FXML
    private TableColumn<Record, String> subjectColumn;
    @FXML
    private TableColumn<Record, String> gradeColumn;

    @FXML
    private Label subjectLabel;
    @FXML
    private Label gradeLabel;
    @FXML
    private Label averageLabel;

    // Reference to the main application.
    private MainApp mainApp;

    public RecordOverviewController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        recordTable.setItems(mainApp.getRecordData());
        setAverage();
    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        subjectColumn.setCellValueFactory(cellData -> cellData.getValue().subjectProperty());
        gradeColumn.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());

        // Clear person details.
        // showRecordDetails();

        // Listen for selection changes and show the person details when changed.
        recordTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showRecordDetails());

        recordTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setAverage());
    }

    private void showRecordDetails() {
        // Record is null, remove all the text.
        // subjectLabel.setText("");
        // gradeLabel.setText("");
        setAverage();
    }

    @FXML
    private void handleDeleteRecord() {
        int selectedIndex = recordTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            recordTable.getItems().remove(selectedIndex);
        } else {
            alertNothingSelected();
        }
    }

    private void alertNothingSelected() {
        // Nothing selected.
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("No Selection");
        alert.setHeaderText("No Record Selected");
        alert.setContentText("Select a record in the table.");

        alert.showAndWait();
    }

    @FXML
    private void handleNewRecord() {
        Record tempRecord = new Record();
        if (mainApp.showPersonEditDialog(tempRecord)) {
            mainApp.getRecordData().add(tempRecord);
            setAverage();
        }
    }

    @FXML
    private void handleEditRecord() {
        Record selectedRecord = recordTable.getSelectionModel().getSelectedItem();
        if (selectedRecord != null) {
            if (mainApp.showPersonEditDialog(selectedRecord)) {
                showRecordDetails();
            }
        } else {
            alertNothingSelected();
        }
    }

    private void setAverage() {
        double total = recordTable.getItems().stream().mapToDouble(Record::getGradeValue).sum();
        double average = (total / recordTable.getItems().size());

        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        decimalFormat.format(average);

        averageLabel.setText(String.valueOf(decimalFormat.format(average)));
    }
}