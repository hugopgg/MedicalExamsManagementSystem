package com.inf5153.controllers;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;


import com.inf5153.Fx;
import com.inf5153.doctor.Doctor;
import com.inf5153.labhub.AppointmentResponse;
import com.inf5153.labhub.LabHub;
import com.inf5153.labhub.ResultsResponse;
import com.inf5153.healthcarecenter.HealthCareCenterManager;
import com.inf5153.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * Controller class for the main application window of the healthcare system.
 * Handles interactions and UI updates related to services, doctors, prescriptions,
 * and appointment results.
 */
public class MainController {

    @FXML
    private ComboBox<Service> serviceComboBox;
    @FXML
    private ComboBox<Doctor> doctorComboBox;
    @FXML
    private Label selectDoctorLabel;
    @FXML
    private Button prescriptionButton;
    @FXML
    private VBox doctorSelectionVBox;
    @FXML
    private VBox serviceDetailsVBox;
    @FXML
    private Label serviceNameLabel;
    @FXML
    private Label servicePhoneLabel;
    @FXML
    private Label serviceEmailLabel;
    @FXML
    private Label serviceDoctorsLabel;
    @FXML
    private ListView<String> requestListView;
    @FXML
    private ListView<String> responseListView;

    private LabHub labHub = LabHub.getInstance();
    private HealthCareCenterManager hccManager = HealthCareCenterManager.getInstance(labHub);
    private Doctor selectedDoctor;

    /**
     * Initializes the controller. Sets up service and doctor selection mechanisms
     * and schedules periodic updates for appointment and results responses.
     */
    @FXML
    private void initialize() {
        initServiceList();
        configureServiceComboBox();
        configureDoctorComboBox();

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this::refreshRequestList, 0, 5, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(this::refreshResponseList, 0, 5, TimeUnit.SECONDS);
    }

    /**
     * Initializes the service ComboBox with available services from the healthcare center.
     */
    private void initServiceList() {
        ObservableList<Service> services = FXCollections.observableArrayList(hccManager.getServices());
        serviceComboBox.setItems(services);
    }

    /**
     * Configures the service ComboBox to display service names.
     */
    private void configureServiceComboBox() {
        serviceComboBox.setCellFactory(param -> new ListCell<Service>() {
            @Override
            protected void updateItem(Service service, boolean empty) {
                super.updateItem(service, empty);
                if (empty || service == null) {
                    setText(null);
                } else {
                    setText(service.getName());
                }
            }
        });

        serviceComboBox.setConverter(new StringConverter<Service>() {
            @Override
            public String toString(Service service) {
                return (service != null) ? service.getName() : null;
            }

            @Override
            public Service fromString(String string) {
                return null;
            }
        });
    }

    /**
     * Configures the doctor ComboBox to display doctor names.
     */
    private void configureDoctorComboBox() {
        doctorComboBox.setCellFactory(param -> new ListCell<Doctor>() {
            @Override
            protected void updateItem(Doctor doctor, boolean empty) {
                super.updateItem(doctor, empty);
                if (empty || doctor == null) {
                    setText(null);
                } else {
                    setText(doctor.getName());
                }
            }
        });

        doctorComboBox.setConverter(new StringConverter<Doctor>() {
            @Override
            public String toString(Doctor doctor) {
                return (doctor != null) ? doctor.getName() : null;
            }

            @Override
            public Doctor fromString(String string) {
                return null;
            }
        });
    }

    /**
     * Handles the selection of a service from the service ComboBox.
     * Populates the doctor ComboBox with doctors from the selected service.
     * Displays service details in the UI.
     * @param event The ActionEvent triggering this method.
     */
    @FXML
    private void handleServiceSelection(ActionEvent event) {
        Service selectedService = serviceComboBox.getValue();
        if (selectedService != null) {
            populateDoctorComboBox(selectedService);
            selectDoctorLabel.setVisible(true);
            doctorComboBox.setVisible(true);
            displayServiceDetails(selectedService);
            serviceDetailsVBox.setVisible(true);
        } else {
            doctorSelectionVBox.setVisible(false);
            doctorComboBox.getItems().clear();
            clearServiceDetails();
            serviceDetailsVBox.setVisible(false);
        }
    }

    /**
     * Populates the doctor ComboBox with doctors from the selected service.
     * @param service The selected service.
     */
    private void populateDoctorComboBox(Service service) {
        ObservableList<Doctor> doctors = FXCollections.observableArrayList(service.getDoctors());
        doctorComboBox.setItems(doctors);
    }

    /**
     * Handles the selection of a doctor from the doctor ComboBox.
     * Sets the selected doctor for further actions.
     * @param event The ActionEvent triggering this method.
     */
    @FXML
    private void handleDoctorSelection(ActionEvent event) {
        selectedDoctor = doctorComboBox.getValue();
        if (selectedDoctor != null) {
            prescriptionButton.setVisible(true);
        } else {
            prescriptionButton.setVisible(false);
        }
    }

    /**
     * Retrieves the currently selected doctor.
     * @return The selected doctor.
     */
    public Doctor getSelectedDoctor() {
        return selectedDoctor;
    }

    /**
     * Handles the prescription action. Opens a new window for prescription details
     * if a doctor is selected, otherwise shows an alert.
     * @param event The ActionEvent triggering this method.
     */
    @FXML
    private void handlePrescription(ActionEvent event) {
        if (selectedDoctor != null) {
            try {
                FXMLLoader loader = new FXMLLoader(Fx.class.getResource("/com/inf5153/Prescription.fxml"));
                Parent root = loader.load();

                PrescriptionController controller = loader.getController();
                controller.setMainController(this);
                controller.setSelectedDoctor(selectedDoctor);

                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Prescription");
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showAlert("No Doctor Selected", "Please select a doctor before making a prescription.");
        }
    }

    /**
     * Shows an alert dialog with the specified title and message.
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
     * Displays details of the selected service in the UI.
     * @param service The selected service.
     */
    private void displayServiceDetails(Service service) {
        serviceNameLabel.setText("Service: " + service.getName());
        servicePhoneLabel.setText("Phone: " + service.getPhone());
        serviceEmailLabel.setText("Email: " + service.getEmail());
        serviceDoctorsLabel.setText("Doctors: " + service.getDoctors().size());
    }

    /**
     * Clears the displayed service details from the UI.
     */
    private void clearServiceDetails() {
        serviceNameLabel.setText("");
        servicePhoneLabel.setText("");
        serviceEmailLabel.setText("");
        serviceDoctorsLabel.setText("");
    }

    /**
     * Refreshes the list of appointment requests from the healthcare center.
     * Updates the requestListView with the latest appointment responses.
     */
    private void refreshRequestList() {
        List<AppointmentResponse> appointmentResponses = hccManager.getReceivedAppointmentResponses();

        ObservableList<String> itemsToShow = FXCollections.observableArrayList();
    
        for (AppointmentResponse response : appointmentResponses) {
            itemsToShow.add(response.toString());
        }
    
        Platform.runLater(() -> {
            requestListView.getItems().clear();
            requestListView.getItems().addAll(itemsToShow);
        });
    }

    /**
     * Refreshes the list of appointment results responses from the healthcare center.
     * Updates the responseListView with the latest results responses.
     */
    private void refreshResponseList() {
        List<ResultsResponse> resultResponses = hccManager.getReceivedResultsResponses();

        ObservableList<String> itemsToShow = FXCollections.observableArrayList();
    
        for (ResultsResponse response : resultResponses) {
            itemsToShow.add(response.toString());
        }
    
        Platform.runLater(() -> {
            responseListView.getItems().clear();
            responseListView.getItems().addAll(itemsToShow);
        });
    }

}
