package bancodio;
public abstract class Conta {
    protected int numero, agencia;
    protected Cliente titular;
    protected static final int AG_PADRAO = 2187;
    protected static int SEQUENCIAL = 1001;
    protected float saldo;
    
    public abstract void depositar(float valor);
    public abstract void sacar(float valor);
    public abstract void transferir(Conta conta, float valor);
    public abstract void extrato();
    public abstract float getSaldo();
    public abstract void setSaldo(float saldo);
    
    public void saqueSimples(float valor){
        this.saldo = (this.saldo - valor);
    }
}
