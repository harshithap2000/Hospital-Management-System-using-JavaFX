package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientLoginController extends Main {

    @FXML
    private TextField usernm;

    @FXML
    private TextField passwrd;

    @FXML
    private Label Wrtext;

    @FXML


    public void on_patient_login(javafx.event.ActionEvent actionEvent) throws SQLException, IOException {
        String query = "select *from patient_login where usrnm=? AND passwrd=?";
        ResultSet rs;
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, usernm.getText());
        pst.setString(2, passwrd.getText());
        rs = pst.executeQuery();
        if (rs.next()) {
            Wrtext.setText("Successful!");
            Main m1 = new Main();
            m1.changeScene("patientDash.fxml");



        }
        else
            Wrtext.setText("Wrong username or password!");

    }
}

