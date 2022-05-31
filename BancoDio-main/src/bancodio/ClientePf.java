package bancodio;
public class ClientePf extends Cliente{
    private String cpf;
    
    public ClientePf(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
    
}
