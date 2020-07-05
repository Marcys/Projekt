package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login_Controller {
    public TextField txtUsername;
    public PasswordField txtPassword;
    public Button btnLogin;

    public void goToMainPage(ActionEvent actionEvent) {
        if (isLoginDetailsCorrect()){
            System.out.println("Login Erfolgreich");

        }
        else System.out.println("Login fehlgeschlagen");

    }


    private boolean isLoginDetailsCorrect() {


        return txtUsername.getText().equals("username") && txtPassword.getText().equals("password");


    }
}