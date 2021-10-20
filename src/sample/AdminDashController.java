package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashController implements Initializable {

    @FXML
    private TextField doctor_name;

    @FXML
    private TextField doctor_id;

    @FXML
    private Label doc_display_text;

    @FXML
    private TextField patient_name;

    @FXML
    private TextField patient_id;

    @FXML
    private Label patient_display_text;
    @FXML
    private BarChart<String, Number> barchart;
    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    public void initialize(URL url, ResourceBundle rb){
        XYChart.Series<String,Number> series=new XYChart.Series<>();
        series.setName("Number of patients");
        series.getData().add(new XYChart.Data<>("Jan",10));
        series.getData().add(new XYChart.Data<>("Feb",20));
        series.getData().add(new XYChart.Data<>("March",50));
        series.getData().add(new XYChart.Data<>("April",50));
        series.getData().add(new XYChart.Data<>("May",60));
        series.getData().add(new XYChart.Data<>("June",70));
        series.getData().add(new XYChart.Data<>("July",50));
        barchart.getData().add(series);
    }
    public void birth_death_reports(javafx.event.ActionEvent actionEvent) throws IOException {
        Main n=new Main();
        n.changeScene("bd_rep.fxml");

    }


    public void discharge_summary(javafx.event.ActionEvent actionEvent) {
    }

    public void home_button(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("AdminDash.fxml");
    }

    public void patient_deet(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("patient_details1.fxml");
    }

    public void doctor_deet(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("doctor_details1.fxml");
    }

    public void staff_deet(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("staff_details.fxml");

    }

    public void fix_appointment(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("fix-appoint.fxml");

    }

    public void room_availability(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("room_available.fxml");
    }


    public void operation_theatre(javafx.event.ActionEvent actionEvent) {

    }

    public void sign_out(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("sample.fxml");
    }


}
