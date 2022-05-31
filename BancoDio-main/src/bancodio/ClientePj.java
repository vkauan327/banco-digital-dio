package bancodio;
public class ClientePj extends Cliente{
    private String cnpj;

    public ClientePj(String nome, String cnpj){
        this.nome = nome;
        this.cnpj = cnpj;
    }
    public String getCnpj() {
        return cnpj;
    }
    
    
}
