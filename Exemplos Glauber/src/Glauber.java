import java.util.Scanner;
import javax.swing.JOptionPane.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Glauber {

    public static void main(String[] args) {

        double num1 , num2, num3;
        
        num1 = Double.parseDouble(JOptionPane.showInputDialog(null,"digite o numero 01: ")); //Já cria a variavel int e converte a String recebida do input para int
        num2 = Double.parseDouble(JOptionPane.showInputDialog(null,"digite o numero 02: ")); //Já cria a variavel int e converte a String recebida do input para int
        num3 = Double.parseDouble(JOptionPane.showInputDialog(null,"digite o numero 03: ")); //Já cria a variavel int e converte a String recebida do input para int

        if(num1 < num2 && num1 < num3){
            System.out.println("O menor numero digitado é: " + num1);
        }
        else if(num2 < num1 && num2 < num3){
            System.out.println("O menor numero digitado é: " + num2);
        }
        else if(num3 < num1 && num3 < num2){
             System.out.println("O menor numero digitado é: " + num3);    
        }
        else{
             System.out.println("Todos os numeros digitados são iguais: ");           
        }      
    } 
}
