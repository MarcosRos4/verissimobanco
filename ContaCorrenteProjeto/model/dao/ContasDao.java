package ContaCorrenteProjeto.model.dao;
// import das classes para a execução das querys e a obtenção das respostas
import java.sql.ResultSet;
import java.sql.Statement;

public class ContasDao {
    // cria a conexão com o bando de dados
    Conexao conexao = new Conexao();
    // acessa as variaveis 
    Statement stm = conexao.getStm();
    ResultSet result = conexao.getResult();
    // imprime todas as contas disponíveis
    public void listarContas() {
        try {
            String minhaQuery = "SELECT * FROM contas ORDER BY nome";
            // executa a query 
            result = stm.executeQuery(minhaQuery);
            // enquanto houver uma resposta da query no Result, imprime os dados da conta
            while (result.next()) {
                System.out.println("ID: "+result.getString("id") + " - Nome: "+result.getString("nome") );
            }
        } catch(Exception e) {
            System.out.println("Erro na lista: "+ e);
        }
    }
    // insere uma nova conta à tabela contas
    public void inserirContas(String nome, String agencias_numero_da_agencia) {
        try {
            String query = String.format(
                "INSERT INTO contas (`numero_da_conta`, `nome`, `saldo`, `agencias_numero_da_agencia`)"+
                // valores numero_da_conta é gerado automaticamente pelo BD, o saldo default é 0
                " VALUES(default, '%s', default, %s);",nome, agencias_numero_da_agencia);
            stm.executeUpdate(query);
            System.out.println(String.format("Conta %s Incluida com SUCESSO" , nome));
            
        } catch(Exception e) {
            System.out.println("Erro na Inclusao: "+ e);
        }
    }
    // altera o saldo de uma conta para um dado valor
    public void setSaldo(String numero_da_conta, String saldo) {
        try {
            String query = String.format("UPDATE contas SET saldo = %s WHERE numero_da_conta = %s;",
            saldo, numero_da_conta);
            stm.executeUpdate(query);
            System.out.println(String.format("Conta Numero: %s alterada com sucesso" , numero_da_conta));
        } catch(Exception e) {
            System.out.println("Erro na Alteracao: "+ e);
        }
    }
    // retorna o saldo atual de uma dada conta
    public float getSaldo(String numero_da_conta) {
        try {
            String minhaQuery = String.format("SELECT saldo FROM contas WHERE numero_da_conta = %s",
            numero_da_conta);
            result = stm.executeQuery(minhaQuery);
            result.next();
            return result.getFloat(1);
        } catch(Exception e) {
            System.out.println("Erro no getSaldo: "+ e);
            return -1;
        }
    }
    // exclui uma conta a partir de um numero_da_conta
    public void excluirByNumero_da_Conta(String numero_da_conta) {
        try {
            String query = String.format("DELETE FROM contas WHERE numero_da_agencia = %s;", numero_da_conta);
            stm.executeUpdate(query);
            System.out.println(String.format("ID: %s EXCLUIDO COM SUCESSO", numero_da_conta));
            
        } catch(Exception e) {
            System.out.println("Erro na Exclusao: "+ e.getMessage());
        }
    }
    // retorna o nome de uma dada conta a partir do numero_da_conta
    public String getNome(String numero_da_conta){
        try {
            String minhaQuery = String.format("SELECT nome FROM contas WHERE numero_da_conta = %s", numero_da_conta);
            result = stm.executeQuery(minhaQuery);
            result.next();
            return result.getString(1);
        } catch(Exception e) {
            System.out.println("Erro no getSaldo: "+ e);
            return "Nome não encontrado";
        }
    }

}
