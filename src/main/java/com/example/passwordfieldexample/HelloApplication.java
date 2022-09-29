package com.example.passwordfieldexample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Creacion de elementos y layout que vamos a utilizar
        Scene scene;
        GridPane grid = new GridPane();
        Label contrasenia = new Label("Contraseña");
        PasswordField pswField = new PasswordField();
        Label aceptar = new Label();
        Label nombre = new Label("Nombre");
        TextField tNombre = new TextField();
        Label edad = new Label("Edad");
        TextField tEdad = new TextField();

        //Configuramos el grid
        grid.setVgap(5);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        //Añadimos los elementos al grid
        grid.addRow(0,nombre,tNombre);
        grid.addRow(1,contrasenia,pswField);
        grid.addRow(2,edad,tEdad);
        grid.add(aceptar,0,3);
        GridPane.setColumnSpan(aceptar,2);
        grid.setHalignment(aceptar, HPos.CENTER);

        pswField.focusedProperty().addListener((observableValue, oldV, newV) -> {

            if (!newV){
                if (pswField.getText().equals("123456")){
                    aceptar.setText("Contraseña comprobada con exito");
                    aceptar.setTextFill(Color.rgb(21, 117, 84));
                }else{
                    aceptar.setText("Contraseña incorrecta");
                    aceptar.setTextFill(Color.rgb(210, 39, 30));
                }
            }else{
                aceptar.setText("");
            }

        });

        /*pswField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!pswField.getText().equals("123456")) {
                    aceptar.setText("Contraseña incorrecta");
                    aceptar.setTextFill(Color.rgb(210, 39, 30));
                } else {
                    aceptar.setText("Contraseña comprobada con exito");
                    aceptar.setTextFill(Color.rgb(21, 117, 84));
                }
                pswField.clear();
            }
        });*/

        scene = new Scene( grid,320, 240);
        stage.setTitle("Ejemplo Password field");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}