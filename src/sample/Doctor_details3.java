package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor_details3 extends Main {

    @FXML
    private TextField doc_id;

    @FXML
    private TextField doc_name;

    @FXML
    private TextField dept_name;

    @FXML
    private Label display_mess;

    public void on_add(javafx.event.ActionEvent actionEvent) {
        String Did,name,dept;
        Did=doc_id.getText();
        int p=Integer.parseInt(Did);
        name=doc_name.getText();
        dept=dept_name.getText();
        try{
            PreparedStatement stm = con.prepareStatement("insert into doctor_det values (?,?,?)");
            stm.setInt(1,p);
            stm.setString(2,name);
            stm.setString(3,dept);
            boolean res;
            res = stm.execute();
            if(!res)
                display_mess.setText("Inserted Successfully!");
            doc_id.setText("");
            doc_name.setText("");
            dept_name.setText("");



        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void on_update(javafx.event.ActionEvent actionEvent) {
        String Did,name,dept;
        Did=doc_id.getText();
        int p=Integer.parseInt(Did);
        name=doc_name.getText();
        dept=dept_name.getText();
        try{
            PreparedStatement stm = con.prepareStatement("update doctor_det set dname=?,dept_name=? where did=?");
            stm.setString(1,name);
            stm.setString(2,dept);
            stm.setInt(3,p);
            boolean res;
            res = stm.execute();
            if(!res)
                display_mess.setText("Updated Successfully!");
            doc_id.setText("");
            doc_name.setText("");
            dept_name.setText("");



        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void on_del(ActionEvent actionEvent) {
        String Did,name,dept;
        Did=doc_id.getText();
        int p=Integer.parseInt(Did);
        try{
            PreparedStatement s = con.prepareStatement("delete from doctor_det where did=?");
            s.setInt(1,p);
            boolean res;
            res = s.execute();
            if(!res) {
                display_mess.setText("Deleted Successfully!");
                doc_id.setText("");
                doc_name.setText("");
                dept_name.setText("");
            }



        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public void on_search(ActionEvent actionEvent) {
        String Did, name, dept;
        Did = doc_id.getText();
        int p = Integer.parseInt(Did);
        try {
            PreparedStatement st = con.prepareStatement("select dname,dept_name from doctor_det where did=?");
            st.setInt(1, p);
            ResultSet rs = st.executeQuery();
            if (rs.next() == true) {
                display_mess.setText("Search Successful!");
                name = rs.getString(1);
                dept = rs.getString(2);
                doc_name.setText(name);
                dept_name.setText(dept);
            } else {
                display_mess.setText("Not Found");
                doc_id.setText("");
                doc_name.setText("");
                dept_name.setText("");

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

        public void on_back2(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("doctor_details1.fxml");
    }
}
