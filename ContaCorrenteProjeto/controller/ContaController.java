package ContaCorrenteProjeto.controller;
// importa classe que vai acessar o banco de dados
import ContaCorrenteProjeto.model.dao.ContasDao;

public class ContaController {
    // numero da conta que vai ser acessada
    private String numero_da_conta, numero_da_agencia;
    private ContasDao conta = new ContasDao();
    // construtor do objeto já define a conta acessada na instanciação
    public ContaController(String numero_da_conta, String numero_da_agencia){
        this.numero_da_conta = numero_da_conta;   
        this.numero_da_agencia = numero_da_agencia;
    }

    // recebe um valor float para sacar
    public void saque(float valor){        
        this.conta.setSaldo(this.numero_da_conta, String.format("%s",(this.conta.getSaldo(this.numero_da_conta, this.numero_da_agencia) - valor)));
        System.out.println("Saque Concluido");
    }

    // recebe um valor para depositar
    public void deposito(float valor){
        // soma o saldo atual ao valor passado
        this.conta.setSaldo(this.numero_da_conta, String.format("%s",
        (this.conta.getSaldo(this.numero_da_conta, this.numero_da_agencia) + valor)));
        System.out.println("Depósito Concluido");
    }
    // retorna String com o saldo
    public String verSaldo() {
        return String.format("Saldo atual R$: %s", this.conta.getSaldo(this.numero_da_conta, this.numero_da_agencia));
    }
    // retorna Float com o saldo
    public float getSaldo(){
        return this.conta.getSaldo(this.numero_da_conta, this.numero_da_agencia);
    }
    
    public boolean podeSacar(float valor){
        if (this.conta.getSaldo(this.numero_da_conta, this.numero_da_agencia) >= valor && valor > 0) {
            return true;
        }
        return false;
    }

    public boolean podeDepositar(float valor){
        if (valor > 0 ) {
            return true;
        }
        return false;
    }
}
