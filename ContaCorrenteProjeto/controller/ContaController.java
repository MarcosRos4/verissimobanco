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
    public boolean saque(float valor){
        // se o valor for menor que o saldo disponível ele executa o saque
        if (this.conta.getSaldo(this.numero_da_conta, this.numero_da_agencia) >= valor) {
            this.conta.setSaldo(this.numero_da_conta, String.format("%s",(this.conta.getSaldo(this.numero_da_conta, this.numero_da_agencia) - valor)));
            System.out.println("Saque Concluido");
            return true;
        }
        // se não ele imprime que o saldo foi insuficiente
        else{
            System.out.println("Saldo insuficiente");
            return false;
        }
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
    
}
