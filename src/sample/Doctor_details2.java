package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Doctor_details2 extends Main {

    @FXML
    private TextField usrname;

    @FXML
    private TextField psswrd;

    @FXML
    private Label display_label;
    @FXML
    private TextField id;

    @FXML

    public void create_button(javafx.event.ActionEvent actionEvent) {
        String Pid,user,pass;
        Pid=id.getText();
        int p=Integer.parseInt(Pid);
        user=usrname.getText();
        pass=psswrd.getText();
        try{
            PreparedStatement stm = con.prepareStatement("insert into Doctor_login values (?,?,?)");
            stm.setInt(1,p);
            stm.setString(2,user);
            stm.setString(3,pass);
            boolean res=stm.execute();
            if(!res)
                display_label.setText("Inserted Successfully!");
            id.setText("");
            usrname.setText("");
            psswrd.setText("");
            con.close();



        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void on_back1(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("doctor_details1.fxml");
    }
}
