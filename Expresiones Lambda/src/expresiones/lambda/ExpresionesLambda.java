/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresiones.lambda;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author GODINOFERRO
 */
public class ExpresionesLambda extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Creamos las Etiquetas
        Label L1 = new Label("Annual Interest Rate:");
        Label L2 = new Label("Number of Years:");
        Label L3 = new Label("Loan Amount:");
        Label L4 = new Label("Monthly Payment:");
        Label L5 = new Label("Total Payment:");
        
        // Creamos las Cajas de texto
        TextField Tf1 = new TextField();
        TextField Tf2 = new TextField();
        TextField Tf3 = new TextField();
        TextField Tf4 = new TextField();
        TextField Tf5 = new TextField();
        
        // Creamos el Botón
        Button btn1 = new Button("Calculate");
        
        //Creando el panel y agregando los componentes
        Pane panel = new Pane();
        
        //Alineacion de los componentes en el panel
        // Alineamos las Label
        L1.setLayoutY(20);
        L1.setLayoutX(10);
        L2.setLayoutY(50);
        L2.setLayoutX(10);
        L3.setLayoutY(80);
        L3.setLayoutX(10);
        L4.setLayoutY(110);
        L4.setLayoutX(10);
        L5.setLayoutY(140);
        L5.setLayoutX(10);
        
        // Alineamos las TextFields
        Tf1.setLayoutY(15);
        Tf1.setLayoutX(150);
        Tf1.setAlignment(Pos.CENTER_RIGHT);
        Tf2.setLayoutY(45);
        Tf2.setLayoutX(150);
        Tf2.setAlignment(Pos.CENTER_RIGHT);
        Tf3.setLayoutY(75);
        Tf3.setLayoutX(150);
        Tf3.setAlignment(Pos.CENTER_RIGHT);
        Tf4.setLayoutY(105);
        Tf4.setLayoutX(150);
        Tf4.setAlignment(Pos.CENTER_RIGHT);
        Tf5.setLayoutY(135);
        Tf5.setLayoutX(150);
        Tf5.setAlignment(Pos.CENTER_RIGHT);
        
        // Alineamos el Button
        btn1.setLayoutY(170);
        btn1.setLayoutX(235);

        
        // Añadimos las Etiquetas al contenedor
        panel.getChildren().addAll(L1,L2,L3,L4,L5,Tf1,Tf2,Tf3,Tf4,Tf5,btn1);
        
        // Creamos la Expresión Lambda
        btn1.setOnAction((ActionEvent e) -> {
            
            // Recogemos los datos de las TextFields
            double intRate = Double.parseDouble(Tf1.getText());
            double years = Double.parseDouble(Tf2.getText());
            double loanAmount = Double.parseDouble(Tf3.getText());
            
            // Calculos necesarios
            double r = intRate/(100*12);
            double m = (loanAmount*r)/(1-(Math.pow(((1+r)), ((-12)*years))));
            double totalPayment = m*(years*12);
            
            // Guardo el resultado en un string para poder mostrarlo en una label.
            // limitando el double a dos decimales.
            DecimalFormat df = new DecimalFormat("#.00");
            String resultado1 = String.valueOf(df.format(m));
            
            // Muestro resultado en el recuadro TextField4
            Tf4.setText(resultado1);
            
            // Muestro resultado en el recuadro TextField5
            String resultado2 = String.valueOf(df.format(totalPayment));
            Tf5.setText(resultado2);
        });
 
        // Medidas para la ventana principal
        Scene scene = new Scene(panel, 325, 225);
        
        // Título de la ventana principal
        primaryStage.setTitle("Calculadora de Préstamo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
