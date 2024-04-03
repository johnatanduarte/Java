package banco.modelo.pagamento;

import java.math.BigDecimal;

public interface DocumentoPagavel {

    //Todo metodo de uma interface é publico e abstrato
    BigDecimal getValorTotal();
    boolean estaPago();
    void quitarPagamento();

    //quando coloco default em um método numa interface, não precisa fazer um override desse método na classe que o implementou
    //mas o metodo precisa ser implementado na interface
    default void imprimirRecibo(){
        System.out.println("RECIBO:");
        System.out.println("Valor total: " + getValorTotal());
        System.out.println("Pago: " + estaPago());
    }
}
