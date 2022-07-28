package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private Label label;

    @FXML
    private TextField text;

    @FXML
    void onClick(ActionEvent event) {
        String title = text.getText();
        int felt = 0;
        try
        {
            felt = Integer.parseInt(title);
            float a = 0;
            float b = 1;
            float c = 0;
            if(felt > 0) {
                for (int i = 0; i < felt; i++) {
                    c = a + b;
                    if (i != 0) {
                        a = b;
                        b = c;
                    }
                }
                label.setText(Float.toString(c));
            } else {
                label.setText("A számnak pozitívnak kell lennie!");
            }
        }
        catch(Exception ex)
        {
            label.setText("Kérem adjon meg egy pozitív egész számot!");
            return;
        }
    }
}
