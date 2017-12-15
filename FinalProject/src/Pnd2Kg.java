/*By Juan Lagos
* CSC 201
* Professor Tanes Kanchanawanchai
* Final Project
* Due Date: 12/14/17
* The project is about converting from one unit of mass to another, with high precision!
* */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Pnd2Kg extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pound2Kg pane = new Pound2Kg();

        primaryStage.setTitle("Multi-Conversion Tool");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    private class Pound2Kg extends GridPane {

        Label lblPound = new Label("Pound:");
        Label lblKg = new Label("Kilogram:");
        Label lblOunce = new Label("Ounce:");

        TextField tfPound = new TextField();
        TextField tfKg = new TextField();
        TextField tfOunce = new TextField();


        private Pound2Kg() {

            setHgap(70);
            setVgap(10);
            setPadding(new Insets(10, 10, 10, 10));

            add(lblPound, 0, 0);
            add(tfPound, 1, 0);
            add(lblKg, 0, 1);
            add(tfKg, 1, 1);
            add(lblOunce, 0, 2);
            add(tfOunce, 1, 2);

            tfPound.setText("0");
            tfPound.setAlignment(Pos.CENTER_RIGHT);
            tfKg.setText("0");
            tfKg.setAlignment(Pos.CENTER_RIGHT);
            tfOunce.setText("0");
            tfOunce.setAlignment(Pos.CENTER_RIGHT);

            tfKg.setOnAction(e -> {
                tfPound.setText(Double.toString(new Double(tfKg.getText()) * 2.20462));
                tfOunce.setText(Double.toString(new Double(tfKg.getText()) * 35.274));
            });

            tfOunce.setOnAction(e -> {
                tfPound.setText(Double.toString(new Double(tfOunce.getText()) / 16));
                tfKg.setText(Double.toString(new Double(tfOunce.getText()) / 35.274));
            });

            tfPound.setOnAction(e -> {
                tfKg.setText(Double.toString(new Double(tfPound.getText()) / 2.20462));
                tfOunce.setText(Double.toString(new Double(tfPound.getText()) * 16));
            });

        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}