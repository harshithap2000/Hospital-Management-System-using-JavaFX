package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PatientDash extends Main{

    @FXML
    private static Label welcome_text;

    @FXML
    private static Label set_name;



    public void room_availability(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("room_available_pat.fxml");

    }

    public void fix_appointment(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("fix-appoin-pat.fxml");
    }

    public void staff_deet(ActionEvent actionEvent) {
    }

    public void home_button(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("patientDash.fxml");

    }

    public void sign_out(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("sample.fxml");
    }





}