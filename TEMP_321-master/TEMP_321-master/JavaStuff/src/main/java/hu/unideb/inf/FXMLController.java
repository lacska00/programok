package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    @FXML
    private Label invalidLabel;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }


    @FXML
    public void close(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }


    @FXML
    public void validateLogin(ActionEvent event) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM `account` WHERE felhnev = '" + userField.getText() + "' AND jelszo = '" + passField.getText() + "'";


        try {
            Statement statement = connectDB.createStatement();
            ResultSet qResult = statement.executeQuery(verifyLogin);


            while(qResult.next()) {
                if(qResult.getInt(1) == 1) {
                    String del3 = "DELETE FROM aktualisFelh";
                    String del5 = "DELETE FROM aktualisOdds";
                    String del6 = "DELETE FROM aktualisId";
                    invalidLabel.setText("Sikerült!");
                    String insertTo = "INSERT INTO aktualisFelh( felhnev) VALUES ('" + userField.getText() + "')";
                    try {
                        String del = "DELETE FROM aktualis";
                        String del2 = "DELETE FROM mybets";
                        String del7 = "DELETE FROM mybets2";
                        Statement statement2 = connectDB.createStatement();
                        statement2.executeUpdate(del);
                        statement2.executeUpdate(del2);
                        statement2.executeUpdate(del3);
                        statement2.executeUpdate(del7);
                        statement2.executeUpdate(del5);
                        statement2.executeUpdate(del6);
                        statement2.executeUpdate( insertTo);
                        Parent root = FXMLLoader.load(getClass().getResource("/fxml/prog.fxml"));
                        Stage progStage = new Stage();
                        Scene scene = new Scene(root);


                        progStage.setScene(scene);
                        progStage.show();
                        scene.getStylesheets().add("/fxml/styles/styles.css");
                        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

                    }catch(Exception e) {
                        e.printStackTrace();
                        e.getCause();
                    }



                } else {
                    invalidLabel.setText("Hiba! Helytelen felhasználónév és/vagy jelszó!");
                }
            }

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    @FXML
    public void createAccount(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/register.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(root);

            registerStage.setScene(scene);
            registerStage.show();
            scene.getStylesheets().add("/fxml/styles/styles.css");
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
