package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FixAppoin extends Main{

    @FXML
    private TextField pat_name;

    @FXML
    private TextField doc_name;

    @FXML
    private TextField date;

    @FXML
    private TextField time;

    @FXML
    private TextField doc_id;

    @FXML
    private TextField pat_id;
    @FXML
    private Label dis_mess;

    public void on_schedule(ActionEvent actionEvent) {
        String Pid,Did, time1 ,date1,  n1,n2;
        Pid = pat_id.getText();
        Did = doc_id.getText();
        date1 = date.getText();
        time1 = time.getText();
        n2 = doc_name.getText();
        n1 = pat_name.getText();
        try {
            String query="select *from appointment where dname=? AND dd=? AND time=?";
            ResultSet rs;
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1,n2);
            pst.setString(2,date1);
            pst.setString(3,time1);
            rs=pst.executeQuery();
            if(rs.next())
            {
                dis_mess.setText("Choose different doctor or time!");
            }
            else
            {
                PreparedStatement psst = con.prepareStatement("insert into appointment values (?,?,?,?,?,?)");

                psst.setString(1,n1);
                psst.setInt(2,Integer.parseInt(Pid));
                psst.setString(3,n2);
                psst.setInt(4,Integer.parseInt(Did));
                psst.setString(5,date1);
                psst.setString(6,time1);
                boolean res;
                res = psst.execute();
                if(!res)
                    dis_mess.setText("Scheduled Successfully!");
                doc_id.setText("");
                doc_name.setText("");
                pat_name.setText("");
                pat_id.setText("");
                time.setText("");
                date.setText("");
            }




        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public void on_go_back(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("AdminDash.fxml");
    }}
