package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class progController  implements Initializable {

    @FXML private ListView<String> listView1;
    @FXML private ListView<String> listView2;
    @FXML private ListView<String> listView3;
    @FXML private ListView<String> listView4;
    @FXML private ListView<String> listView5;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
                load();
    }

    double odds = 1.0;
    int a = 0;
    @FXML
    public void load() {
        odds = 1.0;
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();


        try {
            //a++;
            if(a < 2) {
                listView1.getItems().clear();
                listView2.getItems().clear();
                listView3.getItems().clear();
                listView4.getItems().clear();
                listView5.getItems().clear();
                Statement statement = connectDB.createStatement();
                ResultSet qResult = statement.executeQuery("SELECT * FROM `mybets`");
                String del5 = "DELETE FROM aktualisOdds";
                while (qResult.next()) {
                    String id = qResult.getString(1);
                    Statement statement2 = connectDB.createStatement();
                    ResultSet qResult2 = statement2.executeQuery("SELECT * FROM `football` WHERE fullID='" + id + "'");
                    while (qResult2.next()) {
                            //System.out.println("megyegyezik");
                            listView1.getItems().add("Football");
                            listView2.getItems().add(qResult2.getString(3));
                            listView3.getItems().add(qResult2.getString(4));
                            String bet = qResult.getString(2);
                        //System.out.println(bet);
                            if (bet.equals("h")) {
                                listView4.getItems().add("Hazai");
                            } else if (bet.equals("d")) {
                                listView4.getItems().add("Döntetlen");
                            } else {
                                listView4.getItems().add("Vendég");
                            }
                            if (bet.equals("h")) {
                                listView5.getItems().add(qResult2.getString(5));
                                odds = odds * Double.parseDouble(qResult2.getString(5));
                            } else if (bet.equals("d")) {
                                listView5.getItems().add(qResult2.getString(6));
                                odds = odds * Double.parseDouble(qResult2.getString(6));
                            } else {
                                listView5.getItems().add(qResult2.getString(7));
                                odds = odds * Double.parseDouble(qResult2.getString(7));
                            }
                        }
                }

                ResultSet qResult3 = statement.executeQuery("SELECT * FROM `mybets`");
                while (qResult3.next()) {
                    String id = qResult3.getString(1);
                    Statement statement2 = connectDB.createStatement();
                    ResultSet qResult2 = statement2.executeQuery("SELECT * FROM `kosarLabda` WHERE fullID='" + id + "'");
                    while (qResult2.next()) {
                        //System.out.println("megyegyezik");
                        listView1.getItems().add("Kosárlabda");
                        listView2.getItems().add(qResult2.getString(3));
                        listView3.getItems().add(qResult2.getString(4));
                        String bet = qResult3.getString(2);
                        //System.out.println(bet);
                        if (bet.equals("h")) {
                            listView4.getItems().add("Hazai");
                        } else if (bet.equals("d")) {
                            listView4.getItems().add("Döntetlen");
                        } else {
                            listView4.getItems().add("Vendég");
                        }
                        if (bet.equals("h")) {
                            listView5.getItems().add(qResult2.getString(5));
                            odds = odds * Double.parseDouble(qResult2.getString(5));
                        } else if (bet.equals("v")) {
                            listView5.getItems().add(qResult2.getString(6));
                            odds = odds * Double.parseDouble(qResult2.getString(6));
                        }
                    }
                }

                ResultSet qResult4 = statement.executeQuery("SELECT * FROM `mybets`");
                while (qResult4.next()) {
                    String id = qResult4.getString(1);
                    Statement statement2 = connectDB.createStatement();
                    ResultSet qResult2 = statement2.executeQuery("SELECT * FROM `keziLabda` WHERE fullID='" + id + "'");
                    while (qResult2.next()) {
                        //System.out.println("megyegyezik");
                        listView1.getItems().add("Kézilabda");
                        listView2.getItems().add(qResult2.getString(3));
                        listView3.getItems().add(qResult2.getString(4));
                        String bet = qResult4.getString(2);
                        //System.out.println(bet);
                        if (bet.equals("h")) {
                            listView4.getItems().add("Hazai");
                        } else if (bet.equals("d")) {
                            listView4.getItems().add("Döntetlen");
                        } else {
                            listView4.getItems().add("Vendég");
                        }
                        if (bet.equals("h")) {
                            listView5.getItems().add(qResult2.getString(5));
                            odds = odds * Double.parseDouble(qResult2.getString(5));
                        } else if (bet.equals("d")) {
                            listView5.getItems().add(qResult2.getString(6));
                            odds = odds * Double.parseDouble(qResult2.getString(6));
                        } else {
                            listView5.getItems().add(qResult2.getString(7));
                            odds = odds * Double.parseDouble(qResult2.getString(7));
                        }
                    }
                }
                ResultSet qResult5 = statement.executeQuery("SELECT * FROM `mybets`");
                while (qResult5.next()) {
                    String id = qResult5.getString(1);
                    Statement statement2 = connectDB.createStatement();
                    ResultSet qResult2 = statement2.executeQuery("SELECT * FROM `jegKorong` WHERE fullID='" + id + "'");
                    while (qResult2.next()) {
                        //System.out.println("megyegyezik");
                        listView1.getItems().add("Jég korong");
                        listView2.getItems().add(qResult2.getString(3));
                        listView3.getItems().add(qResult2.getString(4));
                        String bet = qResult5.getString(2);
                        //System.out.println(bet);
                        if (bet.equals("h")) {
                            listView4.getItems().add("Hazai");
                        } else if (bet.equals("d")) {
                            listView4.getItems().add("Döntetlen");
                        } else {
                            listView4.getItems().add("Vendég");
                        }
                        if (bet.equals("h")) {
                            listView5.getItems().add(qResult2.getString(5));
                            odds = odds * Double.parseDouble(qResult2.getString(5));
                        } else if (bet.equals("d")) {
                            listView5.getItems().add(qResult2.getString(6));
                            odds = odds * Double.parseDouble(qResult2.getString(6));
                        } else {
                            listView5.getItems().add(qResult2.getString(7));
                            odds = odds * Double.parseDouble(qResult2.getString(7));
                        }
                    }
                }

                ResultSet qResult6 = statement.executeQuery("SELECT * FROM `mybets`");
                while (qResult6.next()) {
                    String id = qResult6.getString(1);
                    Statement statement2 = connectDB.createStatement();
                    ResultSet qResult2 = statement2.executeQuery("SELECT * FROM `viziLabda` WHERE fullID='" + id + "'");
                    while (qResult2.next()) {
                        //System.out.println("megyegyezik");
                        listView1.getItems().add("Vizilabda");
                        listView2.getItems().add(qResult2.getString(3));
                        listView3.getItems().add(qResult2.getString(4));
                        String bet = qResult6.getString(2);
                        //System.out.println(bet);
                        if (bet.equals("h")) {
                            listView4.getItems().add("Hazai");
                        } else if (bet.equals("d")) {
                            listView4.getItems().add("Döntetlen");
                        } else {
                            listView4.getItems().add("Vendég");
                        }
                        if (bet.equals("h")) {
                            listView5.getItems().add(qResult2.getString(5));
                            odds = odds * Double.parseDouble(qResult2.getString(5));
                        } else if (bet.equals("d")) {
                            listView5.getItems().add(qResult2.getString(6));
                            odds = odds * Double.parseDouble(qResult2.getString(6));
                        } else {
                            listView5.getItems().add(qResult2.getString(7));
                            odds = odds * Double.parseDouble(qResult2.getString(7));
                        }
                    }
                }
                statement.executeUpdate(del5);
                String insertTo = "INSERT INTO aktualisOdds( odds) VALUES ('" + odds + "')";
                if(odds != 1.0) {
                    statement.executeUpdate(insertTo);
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        //System.out.println(odds);
    }

    @FXML
    public void historyPage(ActionEvent event) {


        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/history.fxml"));
            Stage historyStage = new Stage();
            Scene scene2 = new Scene(root);

            historyStage.setScene(scene2);
            historyStage.show();
            scene2.getStylesheets().add("/fxml/styles/styles.css");
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
    public void save(ActionEvent event) {


        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/osszeg.fxml"));
            Stage osszegStage = new Stage();
            Scene scene2 = new Scene(root);

            osszegStage.setScene(scene2);
            osszegStage.show();
            scene2.getStylesheets().add("/fxml/styles/styles.css");
            //((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    public void delete(ActionEvent event) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String del = "DELETE FROM myBets";
        try {
            odds = 1.0;
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(del);
            listView1.getItems().clear();
            listView2.getItems().clear();
            listView3.getItems().clear();
            listView4.getItems().clear();
            listView5.getItems().clear();
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}
