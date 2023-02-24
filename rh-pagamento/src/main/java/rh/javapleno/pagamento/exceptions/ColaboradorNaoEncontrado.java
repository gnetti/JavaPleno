package rh.javapleno.pagamento.exceptions;

public class ColaboradorNaoEncontrado extends RuntimeException{

    public ColaboradorNaoEncontrado(String message){

        super(message);
    }

    public ColaboradorNaoEncontrado(Throwable cause){
          super(cause);
    }
}
