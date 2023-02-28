package rh.javapleno.usuario.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControleException {

    @ExceptionHandler(UsuarioNaoEncontrado.class)
    public ResponseEntity<ErroPadrao> objetoNaoEncontrado(UsuarioNaoEncontrado e, HttpServletRequest request) {
        ErroPadrao error = new ErroPadrao(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
