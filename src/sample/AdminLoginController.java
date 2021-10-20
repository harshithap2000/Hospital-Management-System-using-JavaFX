package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminLoginController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Label logintext;

    @FXML

    public void on_admin_login(ActionEvent actionEvent) throws IOException {
        if(username.getText().toString().equals("Admin")&&password.getText().toString().equals("123")){
            logintext.setText("Success!");
            Main m=new Main();
            m.changeScene("AdminDash.fxml");

        }
        else
            logintext.setText("Wrong username or password!");
    }
    }


