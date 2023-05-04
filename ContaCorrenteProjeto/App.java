package ContaCorrenteProjeto;
import ContaCorrenteProjeto.view.AppView;
import ContaCorrenteProjeto.controller.ContaController;
import ContaCorrenteProjeto.model.dao.ContasDao;
public class App {
    // classe que faz as regras de negocio
    static ContaController contaController;
    // classe que altera o BD
    static ContasDao contasDao = new ContasDao();
    // classe que representa o UI
    static AppView interfacegrafica = new AppView();
    // variavel para imput do usuario
    static String respostaString;

    public static void main(String[] args) {
        // o aplicativo começa com duas opções, ou logar com uma conta já existente ou criar uma nova conta
        interfacegrafica.imprimir("Deseja fazer Login(0) ou Cadastrar nova Conta(1)?\nResposta: ");
        respostaString = interfacegrafica.receberString();
        // se escolher a opção 0 ele segue para o login e as opções de gerenciamento de conta
        if(respostaString.equals("0")){
            interfacegrafica.imprimir("Digite o seu numero_da_conta por favor: ");
            respostaString = interfacegrafica.receberString();
            // salva o numero da conta para poder acessar os gets e sets da conta e fazer alterações no BD
            String numero_da_conta = respostaString;
            try {
                // intancia contaController com o numero_da_conta que vai ser acessada
                contaController = new ContaController(respostaString);
                interfacegrafica.imprimir(String.format("Conta do usuário %s acessada!\n",
                contasDao.getNome(respostaString)));
            } catch (Exception e) {
                interfacegrafica.imprimir(e.getMessage());
            }
            interfacegrafica.imprimir("O que deseja fazer? Saque(1) ou Deposito(2) Ver Saldo(3): ");
            respostaString = interfacegrafica.receberString();
            // se 1 -  saque
            if (respostaString.equals("1")) {
                interfacegrafica.imprimir("Digite o valor do saque: ");
                contaController.saque(interfacegrafica.receberFloat());
            }
            // se 2 - deposito
            else if(respostaString.equals("2")){
                interfacegrafica.imprimir("Digite o valor do depósito: ");
                contaController.deposito(interfacegrafica.receberFloat());
            }
            // se 3 - mostra o saldo atual
            else if(respostaString.equals("3")){
                interfacegrafica.imprimir(String.format("%s", contasDao.getSaldo(numero_da_conta)));
            }
            // se nenhuma das anteriores - mostra que a opção foi invalida e termina a execução do programa
            else{
                interfacegrafica.imprimir("Opção Inválida!");
            }
        }
        // se 1 - cadastra uma nova conta
        else if(respostaString.equals("1")){
            interfacegrafica.imprimir("Para cadastrar uma nova conta digite seu NOME e NUMERO_DA_AGENCIA."+
            "\nAgencias disponíveis: 1111 e 1112"+
            "\nNome: ");
            String nome = interfacegrafica.receberString();
            interfacegrafica.imprimir("Agencia Escolhida: ");
            String numero_da_agencia = interfacegrafica.receberString();
            contasDao.inserirContas(nome, numero_da_agencia);
        }
        // se nenhuma das anteriores - mostra que a opção foi invalida e termina a execução do programa
        else{
            interfacegrafica.imprimir("Opção inválida!");
        }
    }
}
