package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.*;


import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.*;
import javafx.util.Callback;

public class Staff_details implements Initializable {
    Connection con;

    @FXML
    private TableView<ModelTable> table;

    @FXML
    private TableColumn<ModelTable, String> col_did;

    @FXML
    private TableColumn<ModelTable, String> col_name;

    @FXML
    private TableColumn<ModelTable, String> col_dept;





    public void on_back(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("AdminDash.fxml");

    }
    ObservableList<ModelTable> oblist= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital", "root", "root");
            ResultSet rs = con.createStatement().executeQuery("select *from doctor_det");
            while (rs.next()) {
                oblist.add(new ModelTable(rs.getString("did"), rs.getString("dname"), rs.getString("dept_name")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        col_did.setCellValueFactory(new PropertyValueFactory<ModelTable,String>("did"));
    
        col_name.setCellValueFactory(new PropertyValueFactory<ModelTable,String>("dname"));
        col_dept.setCellValueFactory(new PropertyValueFactory<ModelTable,String>("dept_name"));
        table.setItems(oblist);

    }
}
