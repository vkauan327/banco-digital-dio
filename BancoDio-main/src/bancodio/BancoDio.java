package bancodio;

public class BancoDio {

    public static void main(String[] args) {
      ClientePf c1 = new ClientePf("Arnaldo Vieira", "075.379.086-45");
      ContaCorrente cc1 =  new ContaCorrente(c1);
      cc1.depositar(550f);
      //cc1.extrato();
      ContaPoupanca cp1 = new ContaPoupanca(c1);
      cp1.sacar(20.5f);
      //cp1.extrato();
      ClientePf c2 = new ClientePf("Jocsã Pereira da Costa", "745.239.874-03");
      ContaPoupanca cp2 = new ContaPoupanca(c2);
      cp2.depositar(300);
      cp2.sacar(50);
      //cp2.extrato();
      ClientePj c3 = new ClientePj("Encanto das Flores", "57.666.205/0001-32");
      ContaCorrente cc2 = new ContaCorrente(c3, 55000f);
      ClientePf c4 = new ClientePf("Denise Amorim", "536.818.331-77");
      ContaPoupanca cp3 = new ContaPoupanca(c4);
      cp3.depositar(400);
      cp3.transferir(cc2, 257.83f);
      //cp3.extrato();
      //cc2.extrato();
      cp3.depositar(1212);
      cp3.sacar(200);
      cp3.sacar(20);
      cp3.sacar(50);
      cp3.sacar(170);
      cp3.sacar(20);
      cp3.sacar(30);
      //cp3.extrato();
      cc1.transferir(cp2, 100f);
      cp2.extrato();
      cc1.extrato();
    }
    
}
