package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.io.IOException;
public class LandingPage {

    public void Landinpage() {

    }

    @FXML
    public Button admin;
    @FXML
    public Button doctor;
    @FXML
    public Button patient;

    public void adminLogin(ActionEvent event) throws IOException {
        Loginadmin();

    }

    public void Loginadmin() throws IOException {
        Main m = new Main();
        m.changeScene("AdminLogin.fxml");
    }
    public void doctorLogin(ActionEvent event) throws IOException {
        Logindoc();

    }

    public void Logindoc() throws IOException {
        Main m = new Main();
        m.changeScene("DoctorLogin.fxml");
    }
    public void patientLogin(ActionEvent event) throws IOException {
        Loginpatient();

    }

    public void Loginpatient() throws IOException {
        Main m = new Main();
        m.changeScene("PatientLogin.fxml");
    }

}