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



public class detailsController implements Initializable {
    @FXML private ListView<String> listView1;
    @FXML private ListView<String> listView2;
    @FXML private ListView<String> listView3;
    @FXML private ListView<String> listView4;
    @FXML private ListView<String> listView5;
    @FXML private ListView<String> listView6;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        listView1.getItems().clear();
        listView2.getItems().clear();
        listView3.getItems().clear();
        listView4.getItems().clear();
        listView5.getItems().clear();


        int id = 0;
        try {
            Statement statement = connectDB.createStatement();
            ResultSet qResult = statement.executeQuery("SELECT * FROM `aktualisId`");
            while (qResult.next()) {
                id = qResult.getInt(1);
            }
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        String meccsek = "";
        String tippek = "";
        String del2 = "DELETE FROM mybets2";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(del2);
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        try {
            Statement statement = connectDB.createStatement();
            ResultSet qResult = statement.executeQuery("SELECT * FROM `history`");
            while (qResult.next()) {
                if(id == qResult.getInt(1)) {
                    meccsek = qResult.getString(3);
                    tippek = qResult.getString(4);
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        String[] arrOfStr = meccsek.split(" ");
        String[] arrOfStr2 = tippek.split(" ");



        try {
            Statement statement = connectDB.createStatement();
            ResultSet qResult = statement.executeQuery("SELECT * FROM `history`");
            statement.executeUpdate(del2);
            for(int i = 0; i < arrOfStr.length ; i ++) {
                String insertTo = "INSERT INTO mybets2( fullID, bet) VALUES ('" + arrOfStr[i] + "','" + arrOfStr2[i] + "')";
                statement.executeUpdate(insertTo);
            }
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }


        try {
            Statement statement = connectDB.createStatement();
            ResultSet qResult = statement.executeQuery("SELECT * FROM `mybets2`");
            while (qResult.next()) {
                String id2 = qResult.getString(1);
                Statement statement2 = connectDB.createStatement();
                ResultSet qResult2 = statement2.executeQuery("SELECT * FROM `football` WHERE fullID='" + id2 + "'");
                while (qResult2.next()) {
                    listView1.getItems().add("Football");
                    listView2.getItems().add(qResult2.getString(3));
                    listView3.getItems().add(qResult2.getString(4));
                    String bet = qResult.getString(2);
                    if (bet.equals("h")) {
                        listView4.getItems().add("Hazai");
                    } else if (bet.equals("d")) {
                        listView4.getItems().add("Döntetlen");
                    } else {
                        listView4.getItems().add("Vendég");
                    }
                    if (bet.equals("h")) {
                        listView5.getItems().add(qResult2.getString(5));
                    } else if (bet.equals("d")) {
                        listView5.getItems().add(qResult2.getString(6));
                    } else {
                        listView5.getItems().add(qResult2.getString(7));
                    }
                }
            }
            ResultSet qResult3 = statement.executeQuery("SELECT * FROM `mybets2`");
            while (qResult3.next()) {
                String id2 = qResult3.getString(1);
                Statement statement2 = connectDB.createStatement();
                ResultSet qResult2 = statement2.executeQuery("SELECT * FROM `kosarLabda` WHERE fullID='" + id2 + "'");
                while (qResult2.next()) {
                    listView1.getItems().add("Kosárlabda");
                    listView2.getItems().add(qResult2.getString(3));
                    listView3.getItems().add(qResult2.getString(4));
                    String bet = qResult3.getString(2);
                    if (bet.equals("h")) {
                        listView4.getItems().add("Hazai");
                    } else if (bet.equals("d")) {
                        listView4.getItems().add("Döntetlen");
                    } else {
                        listView4.getItems().add("Vendég");
                    }
                    if (bet.equals("h")) {
                        listView5.getItems().add(qResult2.getString(5));
                    } else if (bet.equals("v")) {
                        listView5.getItems().add(qResult2.getString(6));
                    }
                }
            }

            ResultSet qResult4 = statement.executeQuery("SELECT * FROM `mybets2`");
            while (qResult4.next()) {
                String id2 = qResult4.getString(1);
                Statement statement2 = connectDB.createStatement();
                ResultSet qResult2 = statement2.executeQuery("SELECT * FROM `keziLabda` WHERE fullID='" + id2 + "'");
                while (qResult2.next()) {
                    listView1.getItems().add("Kézilabda");
                    listView2.getItems().add(qResult2.getString(3));
                    listView3.getItems().add(qResult2.getString(4));
                    String bet = qResult4.getString(2);
                    if (bet.equals("h")) {
                        listView4.getItems().add("Hazai");
                    } else if (bet.equals("d")) {
                        listView4.getItems().add("Döntetlen");
                    } else {
                        listView4.getItems().add("Vendég");
                    }
                    if (bet.equals("h")) {
                        listView5.getItems().add(qResult2.getString(5));
                    } else if (bet.equals("d")) {
                        listView5.getItems().add(qResult2.getString(6));
                    } else {
                        listView5.getItems().add(qResult2.getString(7));
                    }
                }
            }

            ResultSet qResult5 = statement.executeQuery("SELECT * FROM `mybets2`");
            while (qResult5.next()) {
                String id2 = qResult5.getString(1);
                Statement statement2 = connectDB.createStatement();
                ResultSet qResult2 = statement2.executeQuery("SELECT * FROM `jegKorong` WHERE fullID='" + id2 + "'");
                while (qResult2.next()) {
                    listView1.getItems().add("Jég korong");
                    listView2.getItems().add(qResult2.getString(3));
                    listView3.getItems().add(qResult2.getString(4));
                    String bet = qResult5.getString(2);
                    if (bet.equals("h")) {
                        listView4.getItems().add("Hazai");
                    } else if (bet.equals("d")) {
                        listView4.getItems().add("Döntetlen");
                    } else {
                        listView4.getItems().add("Vendég");
                    }
                    if (bet.equals("h")) {
                        listView5.getItems().add(qResult2.getString(5));
                    } else if (bet.equals("d")) {
                        listView5.getItems().add(qResult2.getString(6));
                    } else {
                        listView5.getItems().add(qResult2.getString(7));
                    }
                }
            }

            ResultSet qResult6 = statement.executeQuery("SELECT * FROM `mybets2`");
            while (qResult6.next()) {
                String id2 = qResult6.getString(1);
                Statement statement2 = connectDB.createStatement();
                ResultSet qResult2 = statement2.executeQuery("SELECT * FROM `viziLabda` WHERE fullID='" + id2 + "'");
                while (qResult2.next()) {
                    listView1.getItems().add("Vizilabda");
                    listView2.getItems().add(qResult2.getString(3));
                    listView3.getItems().add(qResult2.getString(4));
                    String bet = qResult6.getString(2);
                    if (bet.equals("h")) {
                        listView4.getItems().add("Hazai");
                    } else if (bet.equals("d")) {
                        listView4.getItems().add("Döntetlen");
                    } else {
                        listView4.getItems().add("Vendég");
                    }
                    if (bet.equals("h")) {
                        listView5.getItems().add(qResult2.getString(5));
                    } else if (bet.equals("d")) {
                        listView5.getItems().add(qResult2.getString(6));
                    } else {
                        listView5.getItems().add(qResult2.getString(7));
                    }
                }
            }


        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }


    }







    @FXML
    public void close(ActionEvent event) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        try {
            Statement statement = connectDB.createStatement();
            String del6 = "DELETE FROM aktualisId";
            statement.executeUpdate(del6);
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

}
