package com.csbme.awe.controller;

import com.csbme.awe.model.Record;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RecordEditDialogController {

    @FXML
    private TextField subjectField;
    @FXML
    private TextField gradeField;

    private Stage dialogStage;
    private Record record;
    private boolean okClicked = false;

    public boolean isOkClicked() {
        return okClicked;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setRecord(Record record) {
        this.record = record;

        subjectField.setText(record.getSubject());
        gradeField.setText(record.getGrade());
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            record.setSubject(subjectField.getText());
            record.setGrade(gradeField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (subjectField.getText() == null || subjectField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }

        if (gradeField.getText() == null || gradeField.getText().length() == 0) {
            errorMessage += "No valid grade!\n";
        } else {
            // try to parse the grade into an int.
            try {
                Integer.parseInt(gradeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid grade (must be an integer)!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();

            return false;
        }
    }
}