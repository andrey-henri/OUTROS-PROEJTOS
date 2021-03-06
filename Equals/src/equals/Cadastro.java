package equals;

public class Cadastro {
    
    private String cpf;
    private String senha;

    public Cadastro() {
    }

    public Cadastro(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }
    
    public Cadastro(Cadastro objetoCadastro){
        this.cpf = objetoCadastro.getCpf();
        this.senha = objetoCadastro.getSenha();    
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
 
}
