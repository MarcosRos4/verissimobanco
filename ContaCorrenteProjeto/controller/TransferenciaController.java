package ContaCorrenteProjeto.controller;


import ContaCorrenteProjeto.model.dao.TransferenciasDao;

public class TransferenciaController {
    private String numero_da_conta;
    private TransferenciasDao transferencias = new TransferenciasDao();
    
    public TransferenciaController(String numero_da_conta){
        this.numero_da_conta = numero_da_conta;
    }

    public void transferir(String conta_destino, String valor){
        ContaController conta_origem_Controller = new ContaController(this.numero_da_conta);
        ContaController conta_destino_Controller = new ContaController(conta_destino);
        
        if(conta_origem_Controller.saque(Float.parseFloat(valor))){
            conta_destino_Controller.deposito(Float.parseFloat(valor));
            transferencias.criarTransferencia(this.numero_da_conta, conta_destino, valor);
            System.out.println("Transferência realizada com sucesso. ");
        }
    }

    public void mostrarTransferencias() {
        this.transferencias.getExtrato(this.numero_da_conta);
    }
}
