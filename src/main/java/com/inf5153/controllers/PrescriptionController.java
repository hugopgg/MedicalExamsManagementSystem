package com.inf5153.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.inf5153.patient.Patient;
import com.inf5153.prescription.Prescription;
import com.inf5153.prescription.PrescriptionManager;
import com.inf5153.appointment.AppointmentManager;
import com.inf5153.appointment.AppointmentRequest;
import com.inf5153.doctor.Doctor;
import com.inf5153.exam.Exam;
import com.inf5153.exam.composite.CompositeExamType;
import com.inf5153.exam.elementary.ElementaryExamType;
import com.inf5153.healthcarecenter.HealthCareCenterManager;
import com.inf5153.labhub.LabHub;
import com.inf5153.exam.ExamAbstractFactory;
import com.inf5153.exam.ExamFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

/**
 * Controller class for handling prescription creation in the healthcare system.
 * Allows selection of patients, exam types, and parameters for prescription submission.
 */
public class PrescriptionController implements Initializable {

    private MainController mainController;

    @FXML
    private ComboBox<Patient> patientComboBox;

    @FXML
    private Label selectExamLabel;
    @FXML
    private VBox examSelectionVBox;
    @FXML
    private ComboBox<String> examTypeComboBox;
    @FXML
    private ComboBox<String> compositeExamTypeComboBox;
    @FXML
    private ComboBox<String> elementaryExamTypeComboBox;
    @FXML
    private HBox parametersHBox;

    @FXML
    private Label errorLabel;

    private Doctor selectedDoctor;

    /**
     * Sets the reference to the MainController for interaction between controllers.
     * @param mainController The MainController instance.
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configurePatientComboBox();
        configureExamTypeComboBox();
    }

    /**
     * Configures the patient selection ComboBox to display patient names.
     */
    private void configurePatientComboBox() {
        patientComboBox.setCellFactory(param -> new ListCell<Patient>() {
            @Override
            protected void updateItem(Patient patient, boolean empty) {
                super.updateItem(patient, empty);
                if (empty || patient == null) {
                    setText(null);
                } else {
                    setText(patient.getName());
                }
            }
        });

        patientComboBox.setConverter(new StringConverter<Patient>() {
            @Override
            public String toString(Patient patient) {
                return (patient != null) ? patient.getName() : null;
            }

            @Override
            public Patient fromString(String string) {
                return null;
            }
        });
    }

    /**
     * Configures the exam type selection ComboBox with available exam types.
     */
    private void configureExamTypeComboBox() {
        ObservableList<String> examTypes = FXCollections.observableArrayList(
                "Elementary Exam",
                "Composite Exam");
        examTypeComboBox.setItems(examTypes);
    }

    /**
     * Configures the composite exam type selection ComboBox with available composite exam types.
     */
    private void configureCompositeComboBox() {
        ObservableList<String> compositeExamTypes = FXCollections.observableArrayList(CompositeExamType.getAllTypes());
        compositeExamTypeComboBox.setItems(compositeExamTypes);
    }

    /**
     * Configures the elementary exam type selection ComboBox with available elementary exam types.
     */
    private void configureElementaryComboBox() {
        ObservableList<String> elementaryExamTypes = FXCollections
                .observableArrayList(ElementaryExamType.getAllTypes());
        elementaryExamTypeComboBox.setItems(elementaryExamTypes);
    }

    /**
     * Handles the selection of a patient from the patient ComboBox.
     * Shows the exam type selection ComboBox upon patient selection.
     */
    @FXML
    private void handlePatientSelection() {
        Patient selectedPatient = patientComboBox.getValue();
        if (selectedPatient != null) {
            selectExamLabel.setVisible(true);
            examTypeComboBox.setVisible(true);
        }
    }

    /**
     * Handles the selection of an exam type from the exam type ComboBox.
     * Depending on the selected type, either elementary or composite exam creation
     * mechanisms are triggered.
     */
    @FXML
    private void handleExamTypeSelection() {
        String selectedType = examTypeComboBox.getValue();
        if ("Elementary Exam".equals(selectedType)) {
            handleElementaryExamCreation();
        } else if ("Composite Exam".equals(selectedType)) {
            handleCompositeExamCreation();
        }
    }

    /**
     * Handles the selection of a composite exam type from the composite exam type ComboBox.
     */
    @FXML
    private void handleCompositeExamTypeSelection() {
        // Currently unused placeholder method
    }

    /**
     * Handles the selection of an elementary exam type from the elementary exam type ComboBox.
     * Configures the parameters checkboxes based on the selected elementary exam type.
     */
    @FXML
    private void handleElementaryExamTypeSelection() {
        String selectedElementaryType = elementaryExamTypeComboBox.getValue();
        if (selectedElementaryType != null) {
            configureParametersCheckboxes(selectedElementaryType);
        } else {
            errorLabel.setVisible(true);
        }
    }

    /**
     * Retrieves the parameters associated with the selected elementary exam type.
     * @param examType The selected elementary exam type.
     * @return A list of parameters for the selected elementary exam type.
     */
    private List<String> getParametersForElementaryExam(String examType) {
        List<String> parameters = new ArrayList<>();
        switch (examType) {
            case "Blood Analysis":
                parameters.addAll(Arrays.asList("Base", "FSC", "HDL", "TSH"));
                break;
            case "Xray Radiography":
                parameters.addAll(Arrays.asList("Lower Limb", "Upper Limb", "Thorax", "Skull", "Lung"));
                break;
            case "MRI Radiography":
                parameters.addAll(Arrays.asList("Brain", "Spinal Cord", "Hip"));
                break;
            case "Endoscopy":
                parameters.addAll(Arrays.asList("Esophagus", "Bronchial", "Urological"));
                break;
            case "Urine Analysis":
                parameters.addAll(Arrays.asList("Base", "Ph", "Proteinuria", "Glycosuria", "Ketosis"));
                break;
            case "Myelogram":
                break;
            case "Ultrasound":
                parameters.addAll(Arrays.asList("Thyroid", "Brain", "Obstetric"));
                break;
        }
        return parameters;
    }

    /**
     * Configures the parameters checkboxes based on the selected elementary exam type.
     * @param examType The selected elementary exam type.
     */
    private void configureParametersCheckboxes(String examType) {
        parametersHBox.getChildren().clear();
        List<String> parameters = getParametersForElementaryExam(examType);
        for (String parameter : parameters) {
            CheckBox checkBox = new CheckBox(parameter);
            parametersHBox.getChildren().addAll(checkBox, new Label("   "));
        }
        parametersHBox.setVisible(!parameters.isEmpty());
    }

    /**
     * Handles the selection of a composite exam creation.
     * Configures the composite exam type ComboBox for selection.
     */
    private void handleCompositeExamCreation() {
        configureCompositeComboBox();
        compositeExamTypeComboBox.setVisible(true);
        elementaryExamTypeComboBox.setVisible(false);
    }

    /**
     * Handles the selection of an elementary exam creation.
     * Configures the elementary exam type ComboBox for selection.
     */
    private void handleElementaryExamCreation() {
        configureElementaryComboBox();
        elementaryExamTypeComboBox.setVisible(true);
        compositeExamTypeComboBox.setVisible(false);
    }

    /**
     * Handles the submission of the prescription.
     * Creates the appropriate exam based on user selections and submits the prescription request.
     */
    @FXML
    private void handleSubmitPrescription() {
        Patient selectedPatient = patientComboBox.getValue();
        String selectedExamType = examTypeComboBox.getValue();

        if (selectedPatient == null || selectedExamType == null) {
            errorLabel.setVisible(true);
            return;
        }

        Exam exam = null;
        ExamAbstractFactory factory = new ExamFactory();

        if ("Composite Exam".equals(selectedExamType)) {
            String selectedCompositeType = compositeExamTypeComboBox.getValue();
            if (selectedCompositeType != null) {
                exam = factory.createCompositeExam(CompositeExamType.fromDisplayName(selectedCompositeType));
            }
        } else if ("Elementary Exam".equals(selectedExamType)) {
            String selectedElementaryType = elementaryExamTypeComboBox.getValue();
            if (selectedElementaryType != null) {
                List<String> selectedParameters = new ArrayList<>();
                for (Node node : parametersHBox.getChildren()) {
                    if (node instanceof CheckBox) {
                        CheckBox checkBox = (CheckBox) node;
                        if (checkBox.isSelected()) {
                            selectedParameters.add(checkBox.getText());
                        }
                    }
                }

                exam = factory.createElementaryExam(ElementaryExamType.fromDisplayName(selectedElementaryType),
                        selectedParameters.toArray(new String[0]));
            }
        }

        if (exam == null) {
            errorLabel.setVisible(true);
            return;
        }

        if (selectedPatient != null && exam != null) {
            errorLabel.setText("");

            // Show confirmation message
            showAlert("Prescription Submitted",
                    "The appointment request for patient " + selectedPatient.getName() + " has been submitted!");

            // Send appointment request to labhub
            LabHub labHub = LabHub.getInstance();
            HealthCareCenterManager healthCareCenterManager = HealthCareCenterManager.getInstance(labHub);
            AppointmentManager appointmentManager = AppointmentManager.getInstance();
            PrescriptionManager prescriptionManager = PrescriptionManager.getInstance();
            Prescription prescription = prescriptionManager.createPrescription(selectedPatient.getId(), exam);
            AppointmentRequest request = appointmentManager.createAppointmentRequest(prescription);
            healthCareCenterManager.sendAppointmentRequest(request);

            // Reset prescription fields after submission
            resetPrescriptionFields();
        }
    }

    /**
     * Displays an alert dialog with the given title and message.
     * @param title The title of the alert dialog.
     * @param message The message content of the alert dialog.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Resets all prescription-related fields after submission.
     */
    private void resetPrescriptionFields() {
        patientComboBox.getSelectionModel().clearSelection();
        examTypeComboBox.getSelectionModel().clearSelection();
        compositeExamTypeComboBox.getSelectionModel().clearSelection();
        compositeExamTypeComboBox.setVisible(false);
        elementaryExamTypeComboBox.getSelectionModel().clearSelection();
        elementaryExamTypeComboBox.setVisible(false);
        parametersHBox.getChildren().clear();
        parametersHBox.setVisible(false);
        selectExamLabel.setVisible(false);
        examTypeComboBox.setVisible(false);
    }

    /**
     * Sets the selected doctor and initializes the patient list for selection.
     * @param doctor The selected doctor instance.
     */
    public void setSelectedDoctor(Doctor doctor) {
        this.selectedDoctor = doctor;
        initPatientList();
    }

    /**
     * Initializes the patient ComboBox with patients associated with the selected doctor.
     */
    private void initPatientList() {
        if (selectedDoctor != null) {
            ObservableList<Patient> patients = FXCollections.observableArrayList(selectedDoctor.getPatients());
            patientComboBox.setItems(patients);
        }
    }
}
