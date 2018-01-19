package com.csbme.awe.controller;

import com.csbme.awe.MainApp;
import com.csbme.awe.Service.Sqlite;
import com.csbme.awe.model.Record;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.text.DecimalFormat;
import java.util.stream.DoubleStream;

public class RecordOverviewController {
    private static final String NOT_AVAILABLE = "- NA -";
    private static final String FORMAT_TWO_DECIMALS = "##.00";

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
    @FXML
    private Label sumLabel;
    @FXML
    private Label minLabel;
    @FXML
    private Label maxLabel;

    // Reference to the main application.
    private MainApp mainApp;

    private Sqlite sqlite;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        recordTable.setItems(mainApp.getRecordData());
        setAverage();
        setSum();
        setMin();
        setMax();
    }

    @FXML
    private void initialize() {
        setSqlite(new Sqlite());

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
        setAverage();
        setSum();
        setMin();
        setMax();
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
            showRecordDetails();
            getSqlite().insert(tempRecord);
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
        double sum = streamRecordTable().sum();
        double size = recordTable.getItems().size();
        averageLabel.setText(doubleToString((sum / size)));
    }

    private void setSum() {
        sumLabel.setText(doubleToString(streamRecordTable().sum()));
    }

    private void setMin() {
        minLabel.setText(doubleToString(streamRecordTable().min().orElse(0)));
    }

    private void setMax() {
        maxLabel.setText(doubleToString(streamRecordTable().max().orElse(0)));
    }

    private DoubleStream streamRecordTable() {

        return recordTable.getItems().stream().mapToDouble(Record::getGradeValue);
    }

    private boolean isNumberGreaterThanZero(double number) {

        return number > 0;
    }

    private String doubleToString(double number) {
        if (isNumberGreaterThanZero(number)) {
            return doubleWithTwoDecimals(number);
        } else {
            return NOT_AVAILABLE;
        }
    }

    private String doubleWithTwoDecimals(double number) {
        DecimalFormat decimalFormat = new DecimalFormat(FORMAT_TWO_DECIMALS);

        return decimalFormat.format(number);
    }

    public Sqlite getSqlite() {
        return sqlite;
    }

    public void setSqlite(Sqlite sqlite) {
        this.sqlite = sqlite;
    }
}