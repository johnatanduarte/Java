package banco.modelo;

import banco.modelo.excecao.SaldoInsuficienteException;

import java.math.BigDecimal;
import java.util.Objects;

 public abstract class Conta {
    private int agencia;
    private Pessoa titular;
    private int numero;
    private BigDecimal saldo = BigDecimal.ZERO;

    Conta(){

    }

    public Conta(Pessoa titular, int agencia, int numero){
        Objects.requireNonNull(titular); //exige que o titular não seja nulo
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public void depositar(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }
        saldo = saldo.add(valor);
    }

    public void sacar(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }
        if(getSaldoDisponivel().subtract(valor).compareTo(BigDecimal.ZERO) < 0){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        saldo = saldo.subtract(valor);
    }

    public void sacar(BigDecimal valor, BigDecimal taxaSaque){

        sacar(valor.add(taxaSaque));
    }

    public abstract void debitarTarifaMensal();

    public int getAgencia() {
        return agencia;
    }


    public Pessoa getTitular() {
        return titular;
    }

    public int getNumero() {
        return numero;
    }


    public BigDecimal getSaldo() {
        return saldo;
    }
// Eliminar o setSaldo por razçoes de segurança, pois só altera o saldo depositando ou sacando.
//    public void setSaldo(double saldo) {
//        this.saldo = saldo;
//    }
    public BigDecimal getSaldoDisponivel(){
        return getSaldo();
    }

}
