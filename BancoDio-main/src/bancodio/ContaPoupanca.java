package bancodio;
public class ContaPoupanca extends Conta{

    private int qtdesaque;
    
    public ContaPoupanca (Cliente cliente){
        this.titular = cliente;
        this.agencia = AG_PADRAO;
        this.saldo = 150f; //só pode ser criada poupança com depósito inicial de R$150,00
        this.numero = SEQUENCIAL++;
        this.qtdesaque = 0;
    }
    
    @Override
    public void depositar(float valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    @Override
    //após o quinto saque no mês, cobra taxa de 0,15%
    public void sacar(float valor) {
        if (qtdesaque <= 4){
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                this.qtdesaque++;
                System.out.println("Número de saques no mês: " + this.qtdesaque);
            } else {
                System.out.println("Saldo indisponível, saque não realizado");
            }
        } else {
            if (this.getSaldo() >= (valor + valor * 0.015f)) {
                this.setSaldo(this.getSaldo() - (valor + valor * 0.0015f));
                this.qtdesaque++;
                System.out.println("Número de saques no mês: " + this.qtdesaque);
                System.out.println("Taxa de 0,15% cobrada");
            } else {
                System.out.println("Saldo indisponível, saque não realizado");
            }
        }
        
    }

    @Override
    public void transferir(Conta conta, float valor) {
        if (this.getSaldo() >= valor) {
            super.saqueSimples(valor);
            conta.depositar(valor);
        }
    }

    @Override
    public void extrato() {
        System.out.println("-----EXTRATO-----");
        System.out.println("Titular: " + this.titular.getNome() + "\nAgência: " + 
                this.agencia + "\nConta Poupança: " + this.numero);
        System.out.printf("Saldo: R$ %.2f\n", this.saldo); 
        System.out.println("Saques este mês: " + this.qtdesaque);
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
