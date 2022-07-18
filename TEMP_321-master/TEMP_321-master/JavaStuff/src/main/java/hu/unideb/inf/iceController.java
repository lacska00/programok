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

public class iceController  implements Initializable {
    @FXML
    private ListView<String> listView0;
    @FXML private ListView<String> listView1;

    @FXML private ListView<String> listView2;
    @FXML private ListView<String> listView3;
    @FXML
    private Label help;

    int a = 0;
    ArrayList<String> liga = new ArrayList<>();
    ArrayList<String> hazaiCs = new ArrayList<>();
    ArrayList<String> vendegCs = new ArrayList<>();
    ArrayList<String> hOdds = new ArrayList<>();
    ArrayList<String> dOdds = new ArrayList<>();
    ArrayList<String> vOdds = new ArrayList<>();
    ArrayList<String> fullId = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        try {
            Statement statement = connectDB.createStatement();
            ResultSet qResult = statement.executeQuery("SELECT * FROM `jegKorong`");
            int k = 0;
            while (qResult.next()) {
                if(k < 10 && a < 1) {
                    listView0.getItems().add(qResult.getString(1));
                    listView1.getItems().add(qResult.getString(2));
                    listView2.getItems().add(qResult.getString(3));
                    listView3.getItems().add(qResult.getString(4));
                    //listView4.getItems().add(qResult.getString(5));
                    //listView5.getItems().add(qResult.getString(6));
                    //listView6.getItems().add(qResult.getString(7));
                    liga.add(qResult.getString(2));
                    hazaiCs.add(qResult.getString(3));
                    vendegCs.add(qResult.getString(4));
                    hOdds.add(qResult.getString(5));
                    dOdds.add(qResult.getString(6));
                    vOdds.add(qResult.getString(7));
                    fullId.add(qResult.getString(8));
                    k++;
                }
            }
            a++;
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    String s;
    int hmm;
    @FXML
    public void listClick() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        try {
            s = listView0.getSelectionModel().getSelectedItem();
            hmm=Integer.parseInt(s);
            System.out.println(hmm);
            String insertTo = "INSERT INTO aktualis(id, liga, hazaiCsapat, vendegCsapat, hazaiOdds, dontetlenOdds, vendegOdds, fullID) VALUES (1, '" +
                    liga.get(hmm-1) + "','" + hazaiCs.get(hmm-1) + "','"  + vendegCs.get(hmm-1) + "','" + hOdds.get(hmm-1) + "','" + dOdds.get(hmm-1) + "','" + vOdds.get(hmm-1)+ "','" + fullId.get(hmm-1) + "')";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertTo);



            Parent root = FXMLLoader.load(getClass().getResource("/fxml/merkozes.fxml"));
            Stage merkozesStage = new Stage();
            Scene scene = new Scene(root);

            merkozesStage.setScene(scene);
            merkozesStage.show();
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
}
