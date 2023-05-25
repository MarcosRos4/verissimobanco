package ContaCorrenteProjeto.model.dao;

import java.sql.ResultSet;
import java.sql.Statement;

public class TransferenciasDao {
    Conexao conexao = new Conexao();
    // acessa as variaveis
    Statement stm = conexao.getStm();
    ResultSet result = conexao.getResult();

    public void criarTransferencia(String conta_comeco,String conta_destino, String valor){
        try { 
            stm.executeUpdate(String.format(
                "INSERT INTO transferencias (`numero_da_transferencia`,`valor`,`contas_numero_da_conta`, `conta_destino`, `horario_transferencia`)"+
                // valores numero_da_conta é gerado automaticamente pelo BD, o saldo default é 0
                " VALUES(default,'%s', '%s', '%s', default);",valor,conta_comeco,conta_destino));
            System.out.println("Transferência criada com sucesso");

        } catch(Exception e) {
            System.out.println("Erro na Inclusão: "+ e.getMessage());
        }
    }

    public ResultSet getExtrato(String numero_da_conta){
        try {
            String minhaQuery = String.format("SELECT * FROM transferencias WHERE contas_numero_da_conta = %s OR conta_destino = %s",
            numero_da_conta, numero_da_conta);
            return stm.executeQuery(minhaQuery);
            

        } catch(Exception e) {
            System.out.println("Erro na Exibição de Extrato: "+ e);
            return null;
        }


    }
}
