package rh.javapleno.usuario.exceptions;

public class UsuarioNaoEncontrado extends RuntimeException{

    public UsuarioNaoEncontrado(String message){
        super(message);
    }


    public UsuarioNaoEncontrado(Throwable cause){
        super(cause);
    }
}
