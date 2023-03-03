package rh.javapleno.pagamento.exceptions;
public class ProfissaoNaoEncontrada extends RuntimeException{

    public  ProfissaoNaoEncontrada(String message){
        super(message);
    }
    public ProfissaoNaoEncontrada(Throwable cause){

        super(cause);
    }
}
