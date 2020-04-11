import java.util.Scanner;
import javax.swing.*;

public class Glauber1 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        
        String sair = "S";
        double menorNumero = 999999999999999.0;
        int cont = 1;
        
        do{
        
        double numeroDigitado = Double.parseDouble(JOptionPane.showInputDialog(null,"digite o numero: " + cont)); //Já cria a variavel int e converte a String recebida do input para int
        
            if(numeroDigitado < menorNumero){
                menorNumero = numeroDigitado;
            }

            sair = JOptionPane.showInputDialog("Para encerrar a digitação de numeros, digite a Letra 'S' ou 'N' para continuar!\nObs: Se digitar outra coisa vai dar pau!");

            cont++;
            
        }while("N".equals(sair) || "n".equals(sair));
        
        System.out.println("O menor numero digitado foi: " + menorNumero);
    }     
}
