package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Patient_details1 {

    public void on_create_login_doc(javafx.event.ActionEvent actionEvent) throws IOException {


    }


    public void on_addupdel_doc(javafx.event.ActionEvent actionEvent) throws IOException {

    }

    public void on_back(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("AdminDash.fxml");
    }

    public void on_create_login_pat(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("patient_details2.fxml");
    }

    public void on_addupdel_pat(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("patient_details3.fxml");
    }
}
