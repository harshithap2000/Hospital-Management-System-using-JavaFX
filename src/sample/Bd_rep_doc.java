package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Bd_rep_doc implements Initializable {

    @FXML
    private BarChart<String,Number> birth_graph;

    @FXML
    private BarChart<String, Number> death_graph;

    public void initialize(URL url, ResourceBundle rb){
        XYChart.Series<String,Number> series1=new XYChart.Series<>();
        series1.setName("Number of births");
        series1.getData().add(new XYChart.Data<>("Jan",20));
        series1.getData().add(new XYChart.Data<>("Feb",30));
        series1.getData().add(new XYChart.Data<>("March",35));
        series1.getData().add(new XYChart.Data<>("April",50));
        series1.getData().add(new XYChart.Data<>("May",60));
        series1.getData().add(new XYChart.Data<>("June",80));
        series1.getData().add(new XYChart.Data<>("July",30));
        birth_graph.getData().add(series1);

        XYChart.Series<String,Number> series2=new XYChart.Series<>();
        series2.setName("Number of death");
        series2.getData().add(new XYChart.Data<>("Jan",10));
        series2.getData().add(new XYChart.Data<>("Feb",5));
        series2.getData().add(new XYChart.Data<>("March",30));
        series2.getData().add(new XYChart.Data<>("April",9));
        series2.getData().add(new XYChart.Data<>("May",8));
        series2.getData().add(new XYChart.Data<>("June",20));
        series2.getData().add(new XYChart.Data<>("July",15));
        death_graph.getData().add(series2);
    }

    public void on_back(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("doctordash.fxml");

    }
}
