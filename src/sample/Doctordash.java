package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Doctordash {

    @FXML
    void birth_death_reports(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("bd_rep_doc.fxml");
    }

    @FXML
    void fix_appointment(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("fix-appoin-doc.fxml");

    }

    @FXML
    void home_button(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("Doctordash.fxml");

    }

    @FXML
    void patient_deet(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("patient_det_doc.fxml");

    }

    @FXML
    void room_availability(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("room_available_doc.fxml");

    }

    @FXML
    void sign_out(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("sample.fxml");

    }

    @FXML
    void staff_deet(ActionEvent event) {

    }

}

