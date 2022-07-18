package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class merkozesKosar implements Initializable {
    @FXML
    private Label hCsapat;
    @FXML
    private Label vCsapat;
    @FXML
    private Label hOdds;
    @FXML
    private Label vOdds;
    @FXML
    private Label ertesito;
    @FXML private RadioButton radiobutton1;
    @FXML private RadioButton radiobutton2;



    int eredmeny = 0;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO

        ToggleGroup group = new ToggleGroup();
        radiobutton1.setToggleGroup(group);
        radiobutton2.setToggleGroup(group);

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        try {

            Statement statement = connectDB.createStatement();
            ResultSet qResult = statement.executeQuery("SELECT * FROM `aktualis`");
            while (qResult.next()) {
                hCsapat.setText(qResult.getString(3));
                vCsapat.setText(qResult.getString(4));
                hOdds.setText(qResult.getString(5));
                vOdds.setText(qResult.getString(7));
            }


        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    public void katt1() {
        eredmeny = 1;
    }
    @FXML
    public void katt3() {
        eredmeny = 3;
    }
    @FXML
    public void fogadas() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        if(eredmeny != 0) {
            try {
                Statement statement = connectDB.createStatement();
                ResultSet qResult = statement.executeQuery("SELECT * FROM `aktualis`");
                String fullID;
                String bet;
                if(eredmeny == 1) {
                    bet = "h";
                } else if(eredmeny == 2) {
                    bet = "d";
                } else {
                    bet = "v";
                }

                while (qResult.next()) {
                    fullID = qResult.getString(8);
                    String insertTo = "INSERT INTO mybets( fullID, bet) VALUES ('" + fullID + "','" + bet + "')";
                    Statement statement2 = connectDB.createStatement();
                    statement2.executeUpdate(insertTo);
                }

                ertesito.setText("A tipp eltárolásra került");
            }catch(Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        } else {
            ertesito.setText("Jelölj meg valamilyen eredményt!");
        }
    }

    @FXML
    public void backToMainPage(ActionEvent event) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        try {
            String del = "DELETE FROM aktualis WHERE id = 1";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(del);
            /*Parent root = FXMLLoader.load(getClass().getResource("/fxml/prog.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);

            mainStage.setScene(scene);
            mainStage.show();*/
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
