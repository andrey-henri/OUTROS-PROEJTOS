package equals;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Equals {

    public static void main(String[] args) {
        
        Cadastro usuarios = new Cadastro();
        ArrayList <Cadastro> Array_usuarios = new ArrayList <Cadastro>();
        
        usuarios.setCpf("41431336870");
        usuarios.setSenha("1234");
        Array_usuarios.add(new Cadastro(usuarios));
        
        usuarios.setCpf("41431337040");
        usuarios.setSenha("12345");
        Array_usuarios.add(new Cadastro(usuarios));
        
        int statusLogin = 1;
        String validarCpf = (JOptionPane.showInputDialog(null, "Por favor digite seu CPF: "));         
        String validarSenha = (JOptionPane.showInputDialog(null, "Por favor digite sua senha: ")); 
        
        for(int i = 0; i < Array_usuarios.size(); i++){
            if(Array_usuarios.get(i).getCpf().equals(validarCpf) && Array_usuarios.get(i).getSenha().equals(validarSenha)){
                JOptionPane.showMessageDialog(null,"Login realizado com sucesso!");
                statusLogin = 0;
            }
        }
        if(statusLogin == 1){
                JOptionPane.showMessageDialog(null,"Usuario não encontrado!");
        }
    }
    
}
