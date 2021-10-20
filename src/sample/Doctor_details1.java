package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Doctor_details1 {

    public void on_create_login_doc(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("doctor_details2.fxml");

    }


    public void on_addupdel_doc(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("doctor_details3.fxml");
    }

    public void on_back(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("AdminDash.fxml");
    }


}
