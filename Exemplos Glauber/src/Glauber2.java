import java.util.Scanner;
import javax.swing.JOptionPane.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Glauber2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        
        int faixai = 0, faixaii =0, faixaiii = 0, faixaiv =0;
        
        for(int i = 1; i <= 15; i ++){

            double idade = Double.parseDouble(JOptionPane.showInputDialog(null,"Por favor digite a idade da: " + i + " Pessoa.")); //Já cria a variavel int e converte a String recebida do input para int
            
            if(idade < 12){
                faixai++;
            }
            else if(idade >= 12 && idade < 18){
                faixaii++;
            }
            else if(idade >= 18 && idade <= 30){
                faixaiii++;
            }
            else if(idade > 30){
                faixaiv++;
            }
        }
        System.out.println("O numero de pessoas encontradas na faixa etaria I: " + faixai);
        System.out.println("O numero de pessoas encontradas na faixa etaria II: " + faixaii);
        System.out.println("O numero de pessoas encontradas na faixa etaria III: " + faixaiii);
        System.out.println("O numero de pessoas encontradas na faixa etaria IV: " + faixaiv);
         
    }       
}
