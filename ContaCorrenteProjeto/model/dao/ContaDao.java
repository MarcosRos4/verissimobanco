package ContaCorrenteProjeto.model.dao;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContaDao {
    Conexao conexao = new Conexao();
    
    Statement stm = conexao.getStm();
    ResultSet result = conexao.getResult();

    public void listarContas() {
        try {
            String minhaQuery = "SELECT * FROM contas ORDER BY nome";
            result = stm.executeQuery(minhaQuery);
            
            while (result.next()) {
                System.out.println("ID: "+result.getString("id") + " - Nome: "+result.getString("nome") );
            }
        } catch(Exception e) {
            System.out.println("Erro na lista: "+ e);
        }
    }
    public void inserirContas(String nome, int numero_da_agencia) {
        try {
            String query = String.format("INSERT INTO contas (`numero_da_conta`, `nome`, `saldo`, `agencias_numero_da_agencia`) VALUES(default, '%s', default, %d);",nome, numero_da_agencia);
            stm.executeUpdate(query);
            System.out.println("Conta " +nome + "Incluida com SUCESSO" );
            
        } catch(Exception e) {
            System.out.println("Erro na Inclusao: "+ e);
        }
    }
    public void setSaldo(int id, Double saldo) {
        try {
            String query = String.format("UPDATE contas SET saldo = %f  WHERE numero_da_conta = %d;",  saldo, id);
            stm.executeUpdate(query);
            System.out.println("ID: "+ id + " alterado com sucesso" );
        } catch(Exception e) {
            System.out.println("Erro na Alteracao: "+ e);
        }
    }
    public void excluir(String id) {
        try {
            String query = "DELETE FROM aluno WHERE id = " + id + ";";
            stm.executeUpdate(query);
            System.out.println("ID: "+ id + "EXCLUIDO COM SUCESSO");
            
        } catch(Exception e) {
            System.out.println("Erro na Exclusao: "+ e.getMessage());
        }
    }
   public static void main(String[] args) {
    
    ContaDao conta = new ContaDao();
    conta.inserirContas("ivometter", 1112);
    //conta.setSaldo(12, 3333.7);
    float a = 466.5;
    System.out.println(a);

   }
}
