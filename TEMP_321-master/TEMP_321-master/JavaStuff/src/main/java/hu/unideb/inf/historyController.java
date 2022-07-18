package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class historyController implements Initializable{
    @FXML private ListView<String> listView1;
    @FXML private ListView<String> listView2;
    @FXML private ListView<String> listView3;
    @FXML private ListView<String> listView4;
    @FXML
    private Label help;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String nev = "";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet qResult = statement.executeQuery("SELECT * FROM `aktualisFelh`");
            while (qResult.next()) {
                nev = qResult.getString(1);
            }
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        try {
            Statement statement = connectDB.createStatement();
            ResultSet qResult = statement.executeQuery("SELECT * FROM `history`");
            int k = 0;
            while (qResult.next()) {
                if(nev.equals(qResult.getString(2))) {
                    listView1.getItems().add(qResult.getString(1));
                    listView2.getItems().add(qResult.getString(7));
                    listView3.getItems().add(qResult.getString(5));
                    listView4.getItems().add(qResult.getString(6));
                    id.add(qResult.getString(1));
                    meccsek.add(qResult.getString(7));
                    tet.add(qResult.getString(5));
                    odds.add(qResult.getString(6));
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> meccsek = new ArrayList<>();
    ArrayList<String> tet = new ArrayList<>();
    ArrayList<String> odds = new ArrayList<>();

    @FXML
    public void listClick() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String del6 = "DELETE FROM aktualisId";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(del6);
            String s = listView1.getSelectionModel().getSelectedItem();
            int hmm=Integer.parseInt(s);
            String insertTo = "INSERT INTO aktualisId( id) VALUES ('" +  hmm  +"')";
            //System.out.println(insertTo);
            statement.executeUpdate(insertTo);

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/details.fxml"));
            Stage detailsStage = new Stage();
            Scene scene = new Scene(root);

            detailsStage.setScene(scene);
            detailsStage.show();
            scene.getStylesheets().add("/fxml/styles/styles.css");

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }



    @FXML
    public void load() {
        help.setText("Válaszd ki az egyik sorszámát!");
    }



    @FXML
    public void footballPage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/footBall.fxml"));
            Stage footballStage = new Stage();
            Scene scene2 = new Scene(root);

            footballStage.setScene(scene2);
            footballStage.show();
            scene2.getStylesheets().add("/fxml/styles/styles.css");
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    public void handBallPage(ActionEvent event) {


        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/handBall.fxml"));
            Stage handBallStage = new Stage();
            Scene scene2 = new Scene(root);

            handBallStage.setScene(scene2);
            handBallStage.show();
            scene2.getStylesheets().add("/fxml/styles/styles.css");
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    public void icePage(ActionEvent event) {


        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ice.fxml"));
            Stage iceStage = new Stage();
            Scene scene2 = new Scene(root);

            iceStage.setScene(scene2);
            iceStage.show();
            scene2.getStylesheets().add("/fxml/styles/styles.css");
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    public void basketBallPage(ActionEvent event) {


        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/basketBall.fxml"));
            Stage basketBallStage = new Stage();
            Scene scene2 = new Scene(root);

            basketBallStage.setScene(scene2);
            basketBallStage.show();
            scene2.getStylesheets().add("/fxml/styles/styles.css");
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    public void waterPoloPage(ActionEvent event) {


        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/waterPolo.fxml"));
            Stage waterPoloStage = new Stage();
            Scene scene2 = new Scene(root);

            waterPoloStage.setScene(scene2);
            waterPoloStage.show();
            scene2.getStylesheets().add("/fxml/styles/styles.css");
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    public void mainPage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/prog.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);

            mainStage.setScene(scene);
            mainStage.show();
            scene.getStylesheets().add("/fxml/styles/styles.css");
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


}
