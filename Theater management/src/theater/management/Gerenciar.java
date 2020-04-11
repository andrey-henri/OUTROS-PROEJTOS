package theater.management;

import javax.swing.JOptionPane;

public class Gerenciar {
    
    private int colunas = 11, linhas = 10;    
    private Pessoa objeto_pessoa = new Pessoa();
    private Pessoa vetor_pessoa[][] = new Pessoa[colunas][linhas];
    
    public void armazenarVetor(Pessoa vetor_pessoa[][]){
        this.vetor_pessoa = vetor_pessoa;
    }
    
    public String imprimirMapaTeatro(){
        
    String imprimirLinhas = "Colunas:  |                 1"
            + "             |                2"
            + "             |                3"
            + "              |                4"
            + "              |                5"
            + "             |                6"
            + "              |                7"
            + "              |                8"
            + "              |                9"
            + "             |\n"; 
    
    String legenda = "Legenda: "
            + "\nC - Cadeira comum"
            + "\nP - Cadeira preferencial"
            + "\nR - Cadeira reservada\n\n";  
    
        for(int x = 1; x <= colunas; x++){
            for(int y = 1; y < linhas; y++){
                
                if(x == 1 && y == 1){
                    imprimirLinhas += "\nFileira A - | "; 
                }               
                else if(x == 2 && y == 1){
                    imprimirLinhas += "\nFileira B - | ";                    
                }                 
                else if(x == 3 && y == 1){
                    imprimirLinhas += "\nFileira c - | ";                    
                }                   
                else if(x == 4 && y == 1){
                    imprimirLinhas += "\nFileira D - | ";                    
                }                   
                else if(x == 5 && y == 1){
                    imprimirLinhas += "\nFileira E - | ";                    
                }               
                else if(x == 6 && y == 1){
                    imprimirLinhas += "\nFileira F - | ";                    
                }                   
                else if(x == 7 && y == 1){
                    imprimirLinhas += "\nFileira G - | ";                    
                } 
                else if(x == 8 && y == 1){
                    imprimirLinhas += "\nFileira H - | ";                    
                }  
                else if(x == 9 && y == 1){
                    imprimirLinhas += "\nFileira I  - | ";                    
                }    
                else if(x == 10 && y == 1){
                    imprimirLinhas += "\nFileira J - | ";                    
                }                
                if(x == 1 || x == 2 || x == 3 || x == 4 || x == 5 || x == 6 || x == 7 && y <=10){
                    if(vetor_pessoa[x][y] == null){
                        imprimirLinhas += (" C. " + y + "    ( Livre )     | "); 
                    }
                    else{
                        imprimirLinhas += (" C. " + y + " (Ocupado)  | ");                         
                    }
                }                
                if(x == 8 && y <=10){
                    if(vetor_pessoa[x][y] == null){
                        imprimirLinhas += (" P. " + y + "    ( Livre )     | "); 
                    }
                    else{
                        imprimirLinhas += (" P. " + y + " (Ocupado) | ");                         
                    }
                }                  
                if(x == 9 || x == 10 && y <=10){
                    if(vetor_pessoa[x][y] == null){
                        imprimirLinhas += (" R. " + y + "    ( Livre )     | "); 
                    }
                    else{
                        imprimirLinhas += (" R. " + y + " (Ocupado) | ");                         
                    }
                }                                     
            }
            imprimirLinhas += "\n";
        }
        String dadosTeatro;
        dadosTeatro = imprimirLinhas + legenda;  
        return dadosTeatro;
    }   
    
    public String imprimirDadosPessoa(String cpfDigitado){
        String dadosPessoa = "Cpf digitado não foi encontrado (" + cpfDigitado + ") no sistema!";
        for(int x = 1; x < colunas; x++){
            for(int y = 1; y < linhas; y++){
                if(vetor_pessoa[x][y]!= null && vetor_pessoa[x][y].getCPF().equalsIgnoreCase(cpfDigitado)){
                    dadosPessoa = vetor_pessoa[x][y].imprimirDados();
                }            
            }
        }    
        return dadosPessoa;
    }
    
    public String imprimirDadosAssento(String numeroAssento){
        int numeroColuna = numeroColunaAssento(numeroAssento);
        int numeroLinha = Integer.parseInt(numeroAssento.substring(1,2));
        String dadosAssento = vetor_pessoa[numeroColuna][numeroLinha].imprimirDados();
        return dadosAssento;
    }

    public int numeroColunaAssento(String numeroAssento){
        int dadosAssento = 0;
        
        if(numeroAssento.substring(0,1).equalsIgnoreCase("A")){
            dadosAssento = 1;
        }
        else if(numeroAssento.substring(0,1).equalsIgnoreCase("B")){
            dadosAssento = 2;
        }
        else if(numeroAssento.substring(0,1).equalsIgnoreCase("C")){
            dadosAssento = 3;
        }
        else if(numeroAssento.substring(0,1).equalsIgnoreCase("D")){
            dadosAssento = 4;
        }
        else if(numeroAssento.substring(0,1).equalsIgnoreCase("E")){
            dadosAssento = 5;
        }
        else if(numeroAssento.substring(0,1).equalsIgnoreCase("F")){
            dadosAssento = 6;
        }
        else if(numeroAssento.substring(0,1).equalsIgnoreCase("G")){
            dadosAssento = 7;
        }  
        else if(numeroAssento.substring(0,1).equalsIgnoreCase("H")){
            dadosAssento = 8;
        } 
        else if(numeroAssento.substring(0,1).equalsIgnoreCase("I")){
            dadosAssento = 9;
        } 
        else if(numeroAssento.substring(0,1).equalsIgnoreCase("J")){
            dadosAssento = 10;
        }         
        return dadosAssento;
    }
    
    public String letraColunaAssento(Integer numeroAssento){
        String dadosLetra = numeroAssento.toString();
        String dadosNumero = dadosLetra.substring(1, 2);
        if(dadosNumero.equalsIgnoreCase("0")){
            dadosNumero = "" + 1;
        }
        dadosLetra = dadosLetra.substring(0, 1);
        
        if(dadosLetra.equalsIgnoreCase("1")){
           dadosLetra = "A" + dadosNumero; 
        }
        else if(dadosLetra.equalsIgnoreCase("2")){
            dadosLetra = "B" + dadosNumero;
        }
        else if(dadosLetra.equalsIgnoreCase("3")){
            dadosLetra = "C" + dadosNumero;
        }   
        else if(dadosLetra.equalsIgnoreCase("4")){
            dadosLetra = "D" + dadosNumero;
        }
        else if(dadosLetra.equalsIgnoreCase("5")){
            dadosLetra = "E" + dadosNumero;
        }
        else if(dadosLetra.equalsIgnoreCase("6")){
            dadosLetra = "F" + dadosNumero;
        }
        else if(dadosLetra.equalsIgnoreCase("7")){
            dadosLetra = "G" + dadosNumero;
        }
        else if(dadosLetra.equalsIgnoreCase("8")){
            dadosLetra = "H" + dadosNumero;
        }
        else if(dadosLetra.equalsIgnoreCase("9")){
            dadosLetra = "I" + dadosNumero;
        }
        else if(dadosLetra.equalsIgnoreCase("10")){
            dadosLetra = "J" + dadosNumero;
        }        
        return dadosLetra;
    }
}
