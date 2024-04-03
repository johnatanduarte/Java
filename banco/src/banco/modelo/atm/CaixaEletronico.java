package banco.modelo.atm;

import banco.modelo.Conta;
import banco.modelo.pagamento.DocumentoEstornavel;
import banco.modelo.pagamento.DocumentoPagavel;

public class CaixaEletronico {

    public void imprimirSaldo(Conta conta){
        System.out.println("Conta: " + conta.getAgencia() + "/" + conta.getNumero());
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo disponivel: " + conta.getSaldoDisponivel());
    }

    public void pagar(DocumentoPagavel documento, Conta conta){
        if(documento.estaPago()){
            throw new IllegalStateException("Documento já esta pago");
        }
        conta.sacar(documento.getValorTotal());
        documento.quitarPagamento();
    }

    public void esttornarPagamento(DocumentoEstornavel documento, Conta conta){
        if(!documento.estaPago()){
            throw new IllegalStateException("Documento não esta pago");
        }
        conta.depositar(documento.getValorTotal());
        documento.estornarPagamento();

    }

}
