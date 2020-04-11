import java.util.Scanner;
import javax.swing.JOptionPane.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Glauber3 {
    public static void main(String[] args) {
        
        long cpf;
        
        cpf = Long.parseLong(JOptionPane.showInputDialog(null,"Por favor digite o seu CPF: ", "41431336874"));
        JOptionPane.showMessageDialog(null, cpf);
        
    }
    
}
