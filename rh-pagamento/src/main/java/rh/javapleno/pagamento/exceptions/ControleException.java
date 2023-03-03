package rh.javapleno.pagamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControleException {

    @ExceptionHandler(PagamentoNaoEncontrado.class)
    public ResponseEntity<ExceptionPadrao> objetoNaoEncontrado(PagamentoNaoEncontrado e, HttpServletRequest request) {
        ExceptionPadrao error = new ExceptionPadrao(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
