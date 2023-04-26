package rh.javapleno.pagamento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import rh.javapleno.pagamento.controller.PagamentoController;
import rh.javapleno.pagamento.enums.Situacao;
import rh.javapleno.pagamento.model.Pagamento;
import rh.javapleno.pagamento.service.PagamentoService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;

@ExtendWith(MockitoExtension.class)
public class PagamentoControllerTest {
    @InjectMocks
    private PagamentoController pagamentoController;
    @Mock
    private PagamentoService pagamentoService;

    private Pagamento pagamento;


    @BeforeEach
    void setUp() {

        pagamento =  new Pagamento(1L,
                2L,
               LocalDate.of( 12, 12, 2),
                200.00,
                Situacao.ATIVO,
                '1');

    }

    @Test
    void devesalvarPagamento(){
        when(pagamentoService.salvar(pagamento,1L)).thenReturn(pagamento);
        ///pagamentoController.salvar(pagamento,1L);
        var response = assertDoesNotThrow(() ->pagamentoController.salvar(pagamento,1L));
        assertNotNull(response);
        assertEquals(ResponseEntity.status(CREATED).body(pagamento),response);

    }
}
