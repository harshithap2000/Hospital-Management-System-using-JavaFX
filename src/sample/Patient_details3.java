package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Patient_details3 extends Main {

    @FXML
    private TextField name;

    @FXML
    private TextField age;

    @FXML
    private TextField weight;

    @FXML
    private Label display_mess;

    @FXML
    private TextField pat_id;

    @FXML
    private TextField height;

    @FXML
    private TextField diagnosis;

    public void on_add(javafx.event.ActionEvent actionEvent) {

            String Pid, age1, diag, h1, w1, n1;
            Pid = pat_id.getText();
            age1 = age.getText();
            diag = diagnosis.getText();
            h1 = height.getText();
            w1 = weight.getText();
            n1 = name.getText();
            try {
                PreparedStatement stm1 = con.prepareStatement("insert into patient_det values (?,?,?,?,?,?)");
                stm1.setInt(1, Integer.parseInt(Pid));
                stm1.setString(2, n1);
                stm1.setString(3, w1);
                stm1.setString(4, h1);
                stm1.setString(5, diag);
                stm1.setString(6, age1);
                boolean res;
                res = stm1.execute();
                if (!res)
                    display_mess.setText("Inserted Successfully!");
                pat_id.setText("");
                weight.setText("");
                height.setText("");
                diagnosis.setText("");
                age.setText("");
                name.setText("");



            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }


    public void on_update(javafx.event.ActionEvent actionEvent) {

            String Pid, age1, diag, h1, w1, n1;
            Pid = pat_id.getText();
            age1 = age.getText();
            diag = diagnosis.getText();
            h1 = height.getText();
            w1 = weight.getText();
            n1 = name.getText();
            try {
                PreparedStatement stm = con.prepareStatement("update patient_det set pname=?,weight=?,height=?,diagnosis=?,age=? where pid=?");
                stm.setString(1, n1);
                stm.setString(2, w1);
                stm.setString(3, h1);
                stm.setString(4, diag);
                stm.setString(5, age1);
                stm.setInt(6, Integer.parseInt(Pid));
                boolean res;
                if (stm.execute()) res = true;
                else res = false;
                if (!res)
                    display_mess.setText("Updated Successfully!");
                pat_id.setText("");
                weight.setText("");
                height.setText("");
                diagnosis.setText("");
                age.setText("");
                name.setText("");



            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }



    public void on_del(ActionEvent actionEvent) {
        String Pid, age1, diag, h1, w1, n1;
        Pid = pat_id.getText();
        try {
            PreparedStatement stm = con.prepareStatement("delete from patient_det where pid=?");
            stm.setInt(1, Integer.parseInt(Pid));
            boolean res;
            if (stm.execute()) res = true;
            else res = false;
            if (!res)
                display_mess.setText("Deleted Successfully!");
            pat_id.setText("");
            weight.setText("");
            height.setText("");
            diagnosis.setText("");
            age.setText("");
            name.setText("");


        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void on_search(ActionEvent actionEvent) {
        String Pid, age1, diag, h1, w1, n1;
        Pid = pat_id.getText();
        try {
            PreparedStatement stm2 = con.prepareStatement("select pname,weight,height,diagnosis,age from patient_det where pid=?");
            stm2.setInt(1, Integer.parseInt(Pid));
            ResultSet rs=stm2.executeQuery();
           if(rs.next()==true)
           {
               display_mess.setText("Search Successful!");
               n1=rs.getString(1);
               w1=rs.getString(2);
               h1=rs.getString(3);
               diag=rs.getString(4);
               age1=rs.getString(5);
               weight.setText(w1);
               height.setText(h1);
               diagnosis.setText(diag);
               age.setText(age1);
               name.setText(n1);
           }
           else
           {
               display_mess.setText("Not Found!");
               weight.setText("");
               height.setText("");
               diagnosis.setText("");
               age.setText("");
               name.setText("");

           }




        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public void on_back2(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("patient_details1.fxml");
    }
}
