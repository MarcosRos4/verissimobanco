package ContaCorrenteProjeto.controller;

import ContaCorrenteProjeto.model.dao.Conexao;

import java.sql.ResultSet;
import java.sql.Statement;

public class TransferenciasDao {
    Conexao conexao = new Conexao();
    // acessa as variaveis
    Statement stm = conexao.getStm();
    ResultSet result = conexao.getResult();

    public void criarTransferencia(String conta_comeco,String conta_destino, String valor){
        try {
            String query = String.format(
                    "INSERT INTO transferencias (`contas_numero_da_conta`, `conta_destino`, `valor`)"+
                            // valores numero_da_conta é gerado automaticamente pelo BD, o saldo default é 0
                            " VALUES('%s', '%s', '%s');",conta_comeco,conta_destino,valor);
            stm.executeUpdate(query);
        } catch(Exception e) {
            System.out.println("Erro na Inclusao: "+ e);
        }
    }

    public String mostrarExtrato(String numero_conta){

        try {
            String minhaQuery = String.format("SELECT * FROM transferencias WHERE conta_destino = %s", numero_conta);
            result = stm.executeQuery(minhaQuery);
            result.next();
            return result.getString(1);
        } catch(Exception e) {
            System.out.println("Erro na Inclusao: "+ e);
            return "Conta não encontrado";
        }


    }
}
