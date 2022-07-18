package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class osszegController {
    @FXML
    private TextField osszeg;
    @FXML
    private Label eredmeny;

    @FXML
    public void close(ActionEvent event) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        try {
            Statement statement = connectDB.createStatement();
            String del5 = "DELETE FROM aktualisOdds";
            statement.executeUpdate(del5);
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    int szam = 0;
    double k = 0.0;
    @FXML
    public void fogadas(ActionEvent event) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        try {
            Statement statement = connectDB.createStatement();
            ResultSet qResult = statement.executeQuery("SELECT * FROM `aktualisOdds`");
            while (qResult.next()) {
                szam = Integer.parseInt(osszeg.getText());
                k = qResult.getDouble(1);
                eredmeny.setText("" + (szam * qResult.getDouble(1)));
            }
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }




        //odds = k
        //tet = Integer.parseInt(osszeg.getText())
        String felhnev = "";
        String meccsek = "";
        String tippek = "";
        int meccsszam = 0;
        int random = 0;
        try {
            Statement statement = connectDB.createStatement();
            ResultSet qResult = statement.executeQuery("SELECT * FROM `aktualisFelh`");
            while (qResult.next()) {
                felhnev = qResult.getString(1);
                int tet = Integer.parseInt(osszeg.getText());
            }
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }


        try {
            Statement statement = connectDB.createStatement();
            ResultSet qResult2 = statement.executeQuery("SELECT * FROM `myBets`");
            while (qResult2.next()) {
                meccsek = meccsek + qResult2.getString(1) + " ";
                tippek = tippek + qResult2.getString(2) + " ";
                meccsszam++;
            }
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        try {
            Statement statement = connectDB.createStatement();
            ResultSet qResult2 = statement.executeQuery("SELECT * FROM `history`");
            int var = 1;

            while (var > 0) {
                random = ((int) ((Math.random() * 1000) + 1)); // ez lesz az id
                while (qResult2.next()) {
                    if(random == qResult2.getInt(1)) {
                        var++;
                    }
                }
                if(var == 1) {
                    var = 0;
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }


        try {
            Statement statement = connectDB.createStatement();
            String insertTo = "INSERT INTO history( id, felhnev, meccsek, tippek, tet, odds, meccsSzam) VALUES ('" + random + "','" + felhnev + "','"  + meccsek + "','" + tippek + "','" + szam + "','" + k  + "','" + meccsszam +"')";
            statement.executeUpdate( insertTo);
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}
