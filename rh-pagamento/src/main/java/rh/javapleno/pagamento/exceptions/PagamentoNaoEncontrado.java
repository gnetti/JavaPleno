package rh.javapleno.pagamento.exceptions;

public class PagamentoNaoEncontrado extends RuntimeException {
    public PagamentoNaoEncontrado(String message) {

        super(message);
    }

    public PagamentoNaoEncontrado(Throwable cause) {

        super(cause);
    }

}