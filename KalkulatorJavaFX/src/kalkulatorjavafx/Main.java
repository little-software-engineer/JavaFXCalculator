/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulatorjavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class Main extends Application {

    TextField tfNum1;
    TextField tfNum2;
    Button btnDivide; // deljenje
    Button btnMultiply; //mnozenje
    Button btnAddition;  //sabiranje
    Button btnSubtraction; //oduzimanje
    Button btnProcenat; //procenat
    Button btnClear;  //c dugme za ciscenje na kalkulatoru
    Label lblAnswer; //odgovor/resenje

    @Override
    public void start(Stage primaryStage) {

        tfNum1 = new TextField();
        tfNum2 = new TextField();
        btnDivide = new Button("/");
        btnMultiply = new Button("*");
        btnAddition = new Button("+");
        btnSubtraction = new Button("-");
        btnProcenat = new Button("%");
        btnClear = new Button("Clear");
        lblAnswer = new Label("?");

        lblAnswer.setAlignment(Pos.CENTER);
        lblAnswer.setStyle("-fx-border-color: #A52A2A; -fx-padding: 5px;");

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        root.setHgap(10);
        root.setVgap(10);

        root.add(btnDivide, 0, 0);
        root.add(btnMultiply, 1, 0);
        root.add(btnAddition, 0, 1);
        root.add(btnSubtraction, 1, 1);
        root.add(btnProcenat, 0, 2);
        root.add(btnClear, 0, 5, 2, 1);

        root.add(tfNum1, 0, 3);
        root.add(tfNum2, 1, 3);
        root.add(lblAnswer, 0, 4, 2, 1);

        setWidths();
        attachCode();

        Scene scene = new Scene(root, 350, 300);
        primaryStage.setTitle("Bojanin kalkulator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void setWidths() {
        tfNum1.setPrefWidth(70);
        tfNum2.setPrefWidth(70);
        btnDivide.setPrefWidth(70);
        btnMultiply.setPrefWidth(70);
        btnAddition.setPrefWidth(70);
        btnSubtraction.setPrefWidth(70);
        btnProcenat.setPrefWidth(70);
        btnClear.setPrefWidth(150);
        lblAnswer.setPrefWidth(150);
    }

    public void attachCode() {
       
        btnAddition.setOnAction(e -> btncode(e));
        btnSubtraction.setOnAction(e -> btncode(e));
        btnMultiply.setOnAction(e -> btncode(e));
        btnDivide.setOnAction(e -> btncode(e));
        btnProcenat.setOnAction(e -> btncode(e));
        btnClear.setOnAction(e -> btncode(e));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void btncode(ActionEvent e) {
        int num1, num2, answer;
        char symbol;

        if (e.getSource() == btnClear) {
            tfNum1.setText("");
            tfNum2.setText("");
            lblAnswer.setText("?");
            tfNum1.requestFocus();
            return;
        }

   
        num1 = Integer.parseInt(tfNum1.getText());
        num2 = Integer.parseInt(tfNum2.getText());
        if (e.getSource() == btnAddition) {
            symbol = '+';
            answer = num1 + num2;
        } else if (e.getSource() == btnSubtraction) {
            symbol = '-';
            answer = num1 - num2;
        } else if (e.getSource() == btnMultiply) {
            symbol = 'x';
            answer = num1 * num2;
        } else if (e.getSource() == btnProcenat) {
            symbol = '%';
            answer = (num1 * num2) / 100;
        } else {
            symbol = '/';
            answer = num1 / num2;
        }

        lblAnswer.setText("" + num1 + symbol + num2 + "=" + answer);
    }

}
