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
    public float getSaldo(String numero_da_conta, String numero_da_agencia) {
        try {
            result = stm.executeQuery(String.format("SELECT saldo FROM contas WHERE numero_da_conta = %s && agencias_numero_da_agencia = %s",
            numero_da_conta, numero_da_agencia));
            result.next();
            return result.getFloat("saldo");
        } catch(Exception e) {
            return 0;
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
    // retorna o nome de uma dada conta a partir do numero_da_conta e do numero da agencia
    public String getNome(String numero_da_conta, String numero_da_agencia){
        try {
            String minhaQuery = String.format("SELECT nome FROM contas WHERE numero_da_conta = %s && agencias_numero_da_agencia = %s", numero_da_conta, numero_da_agencia);
            result = stm.executeQuery(minhaQuery);
            result.next();
            return result.getString("nome");
        } catch(Exception e) {
            System.out.println("Conta não encontrada.");
            return null;
        }
    }
    // retorna verdadeiro se a conta existe, falso se nao existe
    public boolean existe(String numero_da_conta) {
        try {
            result = stm.executeQuery(String.format("SELECT * from contas WHERE numero_da_conta = %s", numero_da_conta));
            result.next();
            
            if (result.getString("nome") == null) {
                System.out.println("a conta NAO existe yy");
                return false;
            }
            System.out.println("a conta existe");
            return true;
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            System.out.println("a conta NAO existe xx");
            return false;
        }
    }
    // retorna o numero da conta baseado no nome e numero_da_agencia
    public String getNumeroConta(String nome, String numero_da_agencia) {
        try {
            result = stm.executeQuery(String.format("SELECT * from contas WHERE agencias_numero_da_agencia = %s && nome = '%s'", numero_da_agencia, nome));
            result.next();
            return result.getString("numero_da_conta");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
