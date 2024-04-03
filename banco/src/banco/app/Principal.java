package banco.app;

import banco.modelo.*;
import banco.modelo.atm.CaixaEletronico;
import banco.modelo.excecao.SaldoInsuficienteException;
import banco.modelo.pagamento.Boleto;
import banco.modelo.pagamento.DocumentoPagavel;
import banco.modelo.pagamento.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Principal {

    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("Johnatan Duarte");
        titular1.setDocumento("123456");
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setTipo(TipoPessoa.JURIDICA);
        //titular1.setDataUltimaAtualização(LocalDateTime.parse("2023-06-27T13:20:00"));
        System.out.println(titular1.getTipo());

        System.out.println(titular1.getDataUltimaAtualização());

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Joaquina");
        titular2.setDocumento("654321");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123, 987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 222, 333, new BigDecimal("1000"));


        //Conta conta = new Conta(titular1, 123, 987); não se pode instanciar objeto de classe abstrata

//        minhaConta.titular = titular1;
//        minhaConta.agencia = 123;
//        minhaConta.numero = 987;
//        minhaConta.saldo = 15_000;

        try {
            minhaConta.depositar(new BigDecimal("30000"));
            minhaConta.sacar(new BigDecimal("1000"));
            //minhaConta.creditarRendimentos(new BigDecimal("15000"));

            suaConta.depositar(new BigDecimal("15000"));
            suaConta.sacar(new BigDecimal("15500"));
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, new BigDecimal("35000"));
            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal("100"), 160);

            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);

            caixaEletronico.esttornarPagamento(boletoEscola, minhaConta);

            boletoEscola.imprimirRecibo();
            salarioFuncionario.imprimirRecibo();
        } catch (SaldoInsuficienteException e){ //e de exceção
            System.out.println("Erro ao executar operação na conta: " +e.getMessage());
        }
        //        suaConta.setTitular(titular2);
//        suaConta.setAgencia(222);
//        suaConta.setNumero(333);
//        suaConta.saldo = 30_000;

//        System.out.println("Boleto pago: " + boletoEscola.estaPago());
//        System.out.println("Salario pago: " + salarioFuncionario.estaPago());

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);

        //minhaConta.setSaldo(minhaConta.getSaldo() - 40_000);
        //minhaConta.saldo = minhaConta.saldo - 40_000;  Se o saldo fosse publico daria pra burlar o saldo
        //Agora eu só altero o saldo da minha conta através de um saque ou de um deposito

//        System.out.println("Titular: " + minhaConta.getTitular().getNome());
//        System.out.println("Saldo: "+ minhaConta.getSaldo());
//
//        System.out.println("Titular: " + suaConta.getTitular().getNome());
//        System.out.println("Saldo: "+ suaConta.getSaldo());
    }
}
