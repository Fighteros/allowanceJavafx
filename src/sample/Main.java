package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    CheckBox rdFr;
    CheckBox rdEng;
    TextField tfSalary, tfAllowance;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setTop(chkBoxPane());
        Label lbSalary = new Label("Enter Salary");
        Label lbAllow = new Label("Allowance");

        tfSalary = new TextField();
        tfAllowance = new TextField();
        tfAllowance.setEditable(false);

        tfSalary.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                System.out.println("enter pressed");
                tfAllowance.setText(String.valueOf(getAllowance()));
            }
        });
        tfSalary.requestFocus();

        GridPane grdPane =  new GridPane();
        grdPane.addRow(0, lbSalary, tfSalary);
        grdPane.addRow(1, lbAllow, tfAllowance);
        root.setCenter(grdPane);
        primaryStage.setTitle("Test-1819_2_2");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    private HBox chkBoxPane() {
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);

        rdEng = new CheckBox("English");
        rdFr = new CheckBox("French");

        hbox.getChildren().addAll(rdEng, rdFr);
        return hbox;
    }

    private double getAllowance() {
        double allowancePrc = 0;
        double allowance = 0;
        double salary = Double.parseDouble(tfSalary.getText());
        if (rdEng.isSelected() ^ rdFr.isSelected()) {
//            System.out.println("one of them selected");
            allowancePrc = 6.0 / 100;
            allowance = salary * allowancePrc;
        } else if (rdEng.isSelected() && rdFr.isSelected()) {
//            System.out.println("both of them selected");
            allowancePrc = 10.0 / 100;
            allowance = salary * allowancePrc;
        }
/*        System.out.println(salary);
        System.out.println(allowance);
        System.out.println(allowancePrc);*/

        return allowance;
    }
}
