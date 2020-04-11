package theater.management;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class TheaterManagement {

    public static void main(String[] args) {
               
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("OptionPane.yesButtonText", "Sim");  
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.okButtonText", "Confirmar");
        
        Object[] menu_geral = {"1 - Adquerir ingresso",
                               "2 - Consultar cliente",
                               "3 - Mapa do teatro",
                               "4 - Imprimir dados de um assento",     
                               "5 - Sortear brindes",                                                              
                               "9 - Sair da aplicação\n"};  
        
        Object[] menu_tipo = {"1 - Aluno                   ",
                              "2 - Professor               ",
                              "3 - Convidado do Palestrante",
                              "4 - Preferencial            ",                                                            
                              "9 - Outros                   \n"};         
        
        String validaSairAplicacao = "N"; //Valida o encerramento da aplicação
        int numeroColuna, numeroLinha;
        int numeroCadeira;
        int validaGravacaoAssento = 0;
        Pessoa objeto_pessoa = new Pessoa();
        Gerenciar objeto_gerenciar = new Gerenciar();
        Pessoa vetor_pessoa[][] = new Pessoa[11][11];
        
        do{
            try{
                String menu_Geral = (String) JOptionPane.showInputDialog(null,"Selecione alguma das opções abaixo:\n\n","MENU DE FUNCIONALIDADES DO SISTEMA",JOptionPane.QUESTION_MESSAGE,null,menu_geral,null);
                int opcaoMenu_Geral = Integer.parseInt(menu_Geral.substring(0,1));

                switch(opcaoMenu_Geral){

                    case 1:
                        objeto_pessoa.setNome(JOptionPane.showInputDialog(null, "Por favor digite seu nome: ","Ex: Andrey Henrique"));
                        String menu_tipo_pessoa = (String) JOptionPane.showInputDialog(null,"Selecione alguma das opções abaixo:\n\n","MENU DE TIPOS DE PESSOA",JOptionPane.QUESTION_MESSAGE,null,menu_tipo,null);
                        objeto_pessoa.setTipoPessoa(menu_tipo_pessoa.substring(4,28));
                        objeto_pessoa.setCPF(JOptionPane.showInputDialog(null, "Por favor digite seu CPF: ","41431336874"));
                        if(menu_tipo_pessoa.substring(0,1).equals("1")){
                            objeto_pessoa.setRA(JOptionPane.showInputDialog(null, "Por favor digite seu RA: ","21163712"));                    
                        }                    
                        objeto_pessoa.setEmail(JOptionPane.showInputDialog(null, "Por favor digite seu e-mail: ","andrey@pwi.com.br"));                    
                        
                        while(validaGravacaoAssento == 0){
                            do{
                                objeto_pessoa.setNumeroCadeira(JOptionPane.showInputDialog(null,objeto_gerenciar.imprimirMapaTeatro() + "Por favor digite o numero do seu assento:\n", "A2") + " ");
                                if(" ".equals(objeto_pessoa.getNumeroCadeira()) || objeto_pessoa.getNumeroCadeira() == null || objeto_pessoa.getNumeroCadeira().length() < 2 || objeto_pessoa.getNumeroCadeira().length() > 3){
                                    JOptionPane.showMessageDialog(null, "Numero do assento digitado é invalido. Tente selecionar outro!");             
                                }
                            }while(" ".equals(objeto_pessoa.getNumeroCadeira()) || objeto_pessoa.getNumeroCadeira() == null || objeto_pessoa.getNumeroCadeira().length() < 2 || objeto_pessoa.getNumeroCadeira().length() > 3);
                            
                            numeroColuna = objeto_gerenciar.numeroColunaAssento(objeto_pessoa.getNumeroCadeira());
                            numeroLinha = Integer.parseInt(objeto_pessoa.getNumeroCadeira().substring(1,2));
                            
                            if(!" ".equals(objeto_pessoa.getNumeroCadeira().substring(2,3)) || numeroColuna < 1 || numeroColuna > 10 || numeroLinha < 1 || numeroLinha > 10){
                                JOptionPane.showMessageDialog(null, "Numero do assento digitado é invalido. Tente selecionar outro!");
                            }
                            else if(vetor_pessoa[numeroColuna][numeroLinha] == null){
                                if(menu_tipo_pessoa.substring(0,1).equals("1") || menu_tipo_pessoa.substring(0,1).equals("2") || menu_tipo_pessoa.substring(0,1).equals("9")){
                                    if(numeroColuna >0 && numeroColuna <8){
                                        vetor_pessoa[numeroColuna][numeroLinha] = (new Pessoa(objeto_pessoa));
                                        JOptionPane.showMessageDialog(null,"Assento " + objeto_pessoa.getNumeroCadeira() + " reservado com sucesso"); 
                                        validaGravacaoAssento++;
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"O assento digitado não está disponivel para o seu tipo de pessoa: " + objeto_pessoa.getTipoPessoa() + "\nTente novamente!");
                                    }
                                }
                                else if(numeroColuna == 8 && menu_tipo_pessoa.substring(0,1).equals("4")){
                                    vetor_pessoa[numeroColuna][numeroLinha] = (new Pessoa(objeto_pessoa));
                                    JOptionPane.showMessageDialog(null,"Assento " + objeto_pessoa.getNumeroCadeira() + " reservado com sucesso"); 
                                    validaGravacaoAssento++;
                                }
                                else if(numeroColuna >8 && numeroColuna <11 && menu_tipo_pessoa.substring(0,1).equals("3")){
                                    vetor_pessoa[numeroColuna][numeroLinha] = (new Pessoa(objeto_pessoa));
                                    JOptionPane.showMessageDialog(null,"Assento " + objeto_pessoa.getNumeroCadeira() + " reservado com sucesso"); 
                                    validaGravacaoAssento++;
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"O assento digitado não está disponivel para o seu tipo de pessoa: " + objeto_pessoa.getTipoPessoa() + "\nTente novamente!");
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Numero do assento digitado já está ocupado. Tente selecionar outro!");
                            } 
                        }
                        validaGravacaoAssento--;
                        Date data = new Date();
                        objeto_pessoa.setData(data);  
                        objeto_gerenciar.armazenarVetor(vetor_pessoa);
                    break;

                    case 2:
                        objeto_pessoa.setCPF(JOptionPane.showInputDialog(null, "Por favor digite o numero do CPF que deseja consultar: ","41431336874"));
                        JOptionPane.showMessageDialog(null, objeto_gerenciar.imprimirDadosPessoa(objeto_pessoa.getCPF()
                        ));
                    break;

                    case 3:
                        System.out.println("" + objeto_gerenciar.imprimirMapaTeatro());
                        JOptionPane.showMessageDialog(null, objeto_gerenciar.imprimirMapaTeatro());
                    break;

                    case 4:
                        objeto_pessoa.setNumeroCadeira(JOptionPane.showInputDialog(null,"Por favor digite o numero do assento que deseja consultar:\n","Ex: A2"));                    
                        numeroColuna = objeto_gerenciar.numeroColunaAssento(objeto_pessoa.getNumeroCadeira());
                        numeroLinha = Integer.parseInt(objeto_pessoa.getNumeroCadeira().substring(1,2));

                        if(numeroColuna < 1 || numeroColuna > 10 || numeroLinha < 1 || numeroLinha > 10){
                            JOptionPane.showMessageDialog(null, "Numero do assento digitado é invalido!");
                        } 
                        else if(vetor_pessoa[numeroColuna][numeroLinha] == null){
                            JOptionPane.showMessageDialog(null, "Numero do assento digitado ainda está vago!");
                        }
                        else{
                        JOptionPane.showMessageDialog(null, objeto_gerenciar.imprimirDadosAssento(objeto_pessoa.getNumeroCadeira()));
                        }
                    break;

                    case 5:
                        int qtdNumeros = (Integer.parseInt(JOptionPane.showInputDialog(null,"Por favor digite a quantidade de brindes que deseja sortear: ")));
                        String vetor_brindes[];
                        vetor_brindes = new String[qtdNumeros];
                        
                        for(int i = 0; i < vetor_brindes.length; i++){
                            Integer  num = (int) (10 + Math.random() * 80);
                            String converterNumeroColuna = "" + objeto_gerenciar.letraColunaAssento(num);
                            vetor_brindes[i] = "" + converterNumeroColuna;
                            JOptionPane.showMessageDialog(null,"O " + (i+1) + " assento sorteado foi: " + vetor_brindes[i]);
                        }

                    break;

                    case 9:
                        JOptionPane.showMessageDialog(null,"A aplicação será encerrada!");
                        validaSairAplicacao = "S";
                    break;  

                    default: JOptionPane.showMessageDialog(null,"Opção invalida, tente novamente ou digite '9' para Encerrar a aplicação!");                 
                }
            }
            catch (NullPointerException erro) {
                JOptionPane.showMessageDialog(null,"Não foi digitado um valor numerico (Ex: 5)"
                + "\nOperação não pode ser concluida, tente novamente!\n","Erro na digitação",JOptionPane.ERROR_MESSAGE); // Caso não seja digitado um valor numerico
            }
            catch (NumberFormatException erro) {
                JOptionPane.showMessageDialog(null,"Não foi digitado um valor numerico no formato correto (Ex: 7)"
                + "\nOperação não pode ser concluida, tente novamente!\n","Erro na digitação",JOptionPane.ERROR_MESSAGE); // Caso não seja digitado um valor numerico
            }                 
        }while("n".equals(validaSairAplicacao) || "N".equals(validaSairAplicacao));  
    }
}