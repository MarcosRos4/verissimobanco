package ContaCorrenteProjeto.controller;

import java.sql.ResultSet;
import ContaCorrenteProjeto.model.dao.TransferenciasDao;

public class TransferenciaController {
    private String numero_da_conta, numero_da_agencia;
    private TransferenciasDao transferencias = new TransferenciasDao();
    
    public TransferenciaController(String numero_da_conta, String numero_da_agencia){

        this.numero_da_conta = numero_da_conta;
        this.numero_da_agencia = numero_da_agencia;

    }

    public void transferir(String conta_destino, String agencia_destino, String valor){

        ContaController conta_origem_Controller = new ContaController(this.numero_da_conta, this.numero_da_agencia);
        ContaController conta_destino_Controller = new ContaController(conta_destino, agencia_destino);
        conta_origem_Controller.saque(Float.parseFloat(valor));
        conta_destino_Controller.deposito(Float.parseFloat(valor));
        transferencias.criarTransferencia(this.numero_da_conta, conta_destino, valor);
        System.out.println("Transferência realizada com sucesso. ");
       
    }

    public boolean podeTransferir(String conta_destino, String agencia_destino, float valor) {
        if (conta_destino.equals(this.numero_da_conta)){
            return false;
        }
        ContaController conta_origem_Controller = new ContaController(this.numero_da_conta, this.numero_da_agencia);
        ContaController conta_destino_Controller = new ContaController(conta_destino, agencia_destino);

        if(conta_origem_Controller.podeSacar(valor) && conta_destino_Controller.podeDepositar(valor)){
            return true;
        }
        return false;

    }

    public ResultSet mostrarTransferencias() {

        return this.transferencias.getExtrato(this.numero_da_conta);
        
    }
}
