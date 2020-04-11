package theater.management;

import java.util.Date;

public class Pessoa {
    
    private String nome;
    private String tipoPessoa;
    private String CPF;
    private String RA;
    private String email;
    private String numeroCadeira;
    private Date data = new Date();

    public Pessoa() {
    }

    public Pessoa(String nome, String tipoPessoa, String CPF, String RA, String email, String numeroCadeira, Date data) {
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
        this.CPF = CPF;
        this.RA = RA;
        this.email = email;
        this.numeroCadeira = numeroCadeira;
        this.data = data;
    }

    
    public Pessoa(Pessoa objetoPessoa){        
        this.nome = objetoPessoa.getNome();
        this.tipoPessoa = objetoPessoa.getTipoPessoa();
        this.CPF = objetoPessoa.getCPF();        
        this.RA = objetoPessoa.getRA();
        this.email = objetoPessoa.getEmail();
        this.numeroCadeira = objetoPessoa.getNumeroCadeira();
        this.data = objetoPessoa.getData();        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCadeira() {
        return numeroCadeira;
    }

    public void setNumeroCadeira(String numeroCadeira) {
        this.numeroCadeira = numeroCadeira;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public String imprimirDados(){
        String dados;
        dados = "\nNome: " + nome
              + "\nTipo: " + tipoPessoa
              + "\nCPF: " + CPF
              + "\nRA: " + RA
              + "\nE-mail: " + email
              + "\nNumero da cadeira: " + numeroCadeira
              + "\nData: " + data + "\n\n";
        return dados;
    }   
}
