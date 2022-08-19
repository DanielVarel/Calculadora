/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package calculadora;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Danie
 */
public class FXMLController implements Initializable {
        
    Scanner entrada = new Scanner(System.in);
    
    String cadena = "", signo="";
    
    @FXML private Button botonUno;
    @FXML private Button botonDos;
    @FXML private Button botonTres;
    @FXML private Button botonCuatro;
    @FXML private Button botonCinco;
    @FXML private Button botonSeis;
    @FXML private Button botonSiete;
    @FXML private Button botonOcho;
    @FXML private Button botonNueve;
    @FXML private Button botonCero;
    @FXML private Button botonResta;
    @FXML private Button botonSuma;
    @FXML private Button botonMulti;
    @FXML private Button botonDivi;
    @FXML private Button botonIgual;
    @FXML private Button botonLimpiar;
    @FXML private Button botonBorrar;
    @FXML private Button botonReciproco;
    @FXML private Button botonAcercade;
    @FXML private TextField pantalla;   
    
    private ArrayList<String> errores;
    
    double num1, num2, total=0;
    
    @FXML private void uno (){
        cadena = cadena + "1";
        pantalla.setText(cadena);
    }
    
    @FXML private void dos (){
        cadena = cadena + "2";
        pantalla.setText(cadena);
    }
    
    @FXML private void tres (){
         cadena = cadena + "3";
         pantalla.setText(cadena);
    }
    
    @FXML private void cuatro (){
        cadena = cadena + "4";
        pantalla.setText(cadena);
    }
    
    @FXML private void cinco (){
        cadena = cadena + "5";
        pantalla.setText(cadena);
    }
    
    @FXML private void seis (){
         cadena = cadena + "6";
         pantalla.setText(cadena);
    }
    
    @FXML private void siete (){
         cadena = cadena + "7";
         pantalla.setText(cadena);
    }
    
    @FXML private void ocho (){
         cadena = cadena + "8";
         pantalla.setText(cadena);
    }
    
    @FXML private void nueve (){
         cadena = cadena + "9";
         pantalla.setText(cadena);
    }
    
    @FXML private void cero (){
         cadena = cadena + "0";
         pantalla.setText(cadena);
    }
    
    @FXML private void resta (){
         cadena = cadena + " - ";
         pantalla.setText(cadena);
    }
    
    @FXML private void suma (){
         cadena = cadena + " + ";
         pantalla.setText(cadena);
    }
    
    @FXML private void multi (){
         cadena = cadena + " * ";
         pantalla.setText(cadena);
    }
    
    @FXML private void divi (){
         cadena = cadena + " / ";
         pantalla.setText(cadena);
    }
    
    
    
    @FXML private void igual (){
        
        Scanner str = new Scanner(cadena);
        boolean isNumeric = true;  
        
        if(str.hasNext()){
            
            String numero1 = str.next();
            
            for (int i = 0; i < numero1.length(); i++) {
                if (!Character.isDigit(numero1.charAt(i))) {
                    isNumeric = false;
                }
            }
            
            if(isNumeric){
                num1 = Double.parseDouble(numero1);
            }else{
                alertaOperacion();
            }   
        }
        
        if(str.hasNext()){
            String operador = str.next();
            if(operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/")){
                signo = operador;
            }
        }else{
            signo = " ";
        }
        
        isNumeric = true;
        
        if(str.hasNext()){
            
            String numero2 = str.next();
            
            for (int i = 0; i < numero2.length(); i++) {
                if (!Character.isDigit(numero2.charAt(i))) {
                    isNumeric = false;
                }
            }
            
            if(isNumeric){
                num2 = Double.parseDouble(numero2);
            }else{
                alertaOperacion();
            }   
            
            cadena = "";
        }
        
        validar();
        if (errores.size() > 0){
            limpiar ();
            String cadenaErrores = "";
            
            for (int i=0; i<errores.size(); i++){
                cadenaErrores += errores.get(i) + "\n";
            }
            Alert mensaje = new Alert(Alert.AlertType.ERROR); //ESTO LO QUE HACE ES MOSTRAR UN CUADRO DE DIALOGO PORQUE HAY ERRORES
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Operacion no valida");
            mensaje.setContentText(cadenaErrores);
            mensaje.show();
        }
        
        
        switch(signo){
            case "+": 
                total = num1 + num2;
                break;
            case "-": 
                total = num1 - num2;
                break;
            case "*": 
                total = num1 * num2;
                break;
            case "/": 
                total = num1 / num2;
                break;
            case " ": 
                total = num1;
                break;
        }
        
        
        pantalla.clear();
        String salida;
        
        salida = Double.toString(total);
        
        pantalla.setText(salida);

    }
    
    @FXML private void limpiar (){
         pantalla.clear();
         cadena = "";
         total = 0;
         num1=0;
         num2=0;
         signo = " ";
    }
    
    
    @FXML private void botonBorrar (){
         cadena = cadena.replaceFirst(".$","");
         pantalla.setText(cadena);
    }
    
    @FXML private void botonReciproco (){
        Scanner str = new Scanner(cadena);
        
        if(str.hasNext()){
            num1 = Double.parseDouble(str.next());
        }else{
            num1=0;
        }
        
         total = Math.pow(num1, -1 );
         String salida;
         salida = Double.toString(total); 
         pantalla.setText(salida);
    }
    
    private void validar(){
        errores.clear(); //HACE QUE EL ARREGLO ESTE VACÍO EN CADA LLAMADO
        if (num2 == 0){
            if(signo.equals("/")){
                errores.add("Prohibido dividir entre cero"); 
            }
        }    
        
    }
    
    private void alertaOperacion(){
         Alert alert = new Alert(AlertType.INFORMATION);
         alert.setTitle("Error en la operacion");
         alert.setHeaderText("Operaciones validas");
         alert.setContentText("num1 + num2\n"
                 + "num1 - num2\n"
                 + "num1 * num2\n"
                 + "num1 / num2\n");
         limpiar ();
         alert.showAndWait();  
    }
    
    
    
    @FXML private void botonAcercade (){
         Alert alert = new Alert(AlertType.INFORMATION);
         alert.setTitle("Acerca de la aplicacion..");
         alert.setHeaderText("Daniel Alejandro Avila Varela");
         alert.setContentText("Calculadora v.1 \n"
                 + "Numero de cuenta: 20191030337 \n"
                 + "UNAH");
         
         alert.showAndWait();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errores = new ArrayList<String>();
    }    
    
}
