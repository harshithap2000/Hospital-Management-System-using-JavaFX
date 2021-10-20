package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorLoginController extends Main{

    @FXML
    private TextField usr;

    @FXML
    private TextField pass;

    @FXML
    private Label loginText;

    @FXML
    void on_doctor_login(ActionEvent event) {

    }

    public void on_doctor_login(javafx.event.ActionEvent actionEvent) throws SQLException, IOException {
        String query="select *from doctor_login where usernm=? AND psswrd=?";
        ResultSet rs;
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1,usr.getText());
        pst.setString(2,pass.getText());
        rs=pst.executeQuery();
        if(rs.next())
        {
            loginText.setText("Successful!");
            Main m=new Main();
            m.changeScene("doctordash.fxml");
        }
        else
            loginText.setText("Wrong Username or Password!");


    }}



