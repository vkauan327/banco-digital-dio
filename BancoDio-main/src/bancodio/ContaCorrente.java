package bancodio;
public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente){
        this.titular = cliente;
        this.agencia = AG_PADRAO;
        this.saldo = 0;
        this.numero = SEQUENCIAL++;
    }
    
    //criar conta com depósito inicial
    public ContaCorrente(Cliente cliente, float valor) {
        this.titular = cliente;
        this.agencia = AG_PADRAO;
        this.saldo = valor;
        this.numero = SEQUENCIAL++;
    }
    
  
    @Override
    public void depositar(float valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    @Override
    //0,3% de taxa de saque
    public void sacar(float valor) {
        if (this.getSaldo() >= (valor + valor * 0.003f)) {
            this.setSaldo(this.getSaldo() - (valor + this.getSaldo() * 0.003f));
        } else {
            System.out.println("Saldo insuficiente, saque não realizado");
        }
    }

    @Override
    //0,2% de taxa de transferência
    public void transferir(Conta conta, float valor) {
        if (this.getSaldo() >= (valor + valor * 0.002f)) {
           super.saqueSimples(valor + valor * 0.002f);
           conta.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente, transferência não realizada");
        }
    }

    @Override
    public void extrato() {
        System.out.println("-----EXTRATO-----");
        System.out.println("Titular: " + this.titular.getNome() + "\nAgência: " + this.agencia + 
                "\nConta Corrente: " + this.numero);
        System.out.printf("Saldo: R$ %.2f\n", this.saldo);
    }

    @Override
    public float getSaldo() {
        return this.saldo;
    }

    @Override
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
}
