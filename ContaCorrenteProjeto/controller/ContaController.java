package ContaCorrenteProjeto.controller;
// importa classe que vai acessar o banco de dados
import ContaCorrenteProjeto.model.dao.ContasDao;

public class ContaController {
    // numero da conta que vai ser acessada
    private String numero_da_conta;
    ContasDao conta = new ContasDao();
    // construtor do objeto já define a conta acessada na instanciação
    public ContaController(String numero_da_conta){
        this.numero_da_conta = numero_da_conta;   
    }
    // recebe um valor float para sacar
    public void saque(float valor){
        // se o valor for menor que o saldo disponível ele executa o saque
        if (conta.getSaldo(this.numero_da_conta) > valor) {
            conta.setSaldo(this.numero_da_conta, String.format("%s",(conta.getSaldo(this.numero_da_conta) - valor)));
            System.out.println("Saque Concluido");
        }
        // se não ele imprime que o saldo foi insuficiente
        else{
            System.out.println("Saldo insuficiente");
        }
    }
    // recebe um valor para depositar
    public void deposito(float valor){
        // soma o saldo atual ao valor passado
        conta.setSaldo(this.numero_da_conta, String.format("%s",
        (conta.getSaldo(this.numero_da_conta) + valor)));
        System.out.println("Depósito Concluido");
    }
    

}
