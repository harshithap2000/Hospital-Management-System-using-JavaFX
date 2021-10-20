package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomAvaiilablePat extends Main {

    @FXML
    private TextField room_no;

    @FXML
    private TextField patient_id;

    @FXML
    private TextField patient_name;
    @FXML
    private TextField room_no1;
    @FXML
    private Label dis_mess1;

    @FXML
    private Label diss_mess2;

    public void on_check_available(ActionEvent actionEvent) {
        String rn, avail1;
        rn = room_no.getText();
        try {
            PreparedStatement st = con.prepareStatement("select avail from room where room_no=?");
            st.setInt(1, Integer.parseInt(rn));
            ResultSet rs = st.executeQuery();
            if (rs.next() == true) {
                avail1 = rs.getString(1);
                if (avail1.equalsIgnoreCase("Y"))
                    dis_mess1.setText("Room Available!!");
                else
                    dis_mess1.setText("Room Not Available");


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void on_go_back(ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("patientDash.fxml");

    }

    public void on_book_now(ActionEvent actionEvent) throws IOException {
        String Pid, n1, rn, avail1 = "N";
        Pid = patient_id.getText();
        n1 = patient_name.getText();
        rn = room_no1.getText();
        try {
            PreparedStatement stm1 = con.prepareStatement("update room set pid=?,pname=?,avail=? where room_no=?");
            stm1.setInt(1, Integer.parseInt(Pid));
            stm1.setString(2, n1);
            stm1.setString(3, avail1);
            stm1.setInt(4, Integer.parseInt(rn));
            boolean res;
            res = stm1.execute();
            if (!res)
                diss_mess2.setText("Booked Successfully!");
            patient_id.setText("");
            patient_name.setText("");
            room_no1.setText("");


        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
}
