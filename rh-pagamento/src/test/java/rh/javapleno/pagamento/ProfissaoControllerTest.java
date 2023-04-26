package rh.javapleno.pagamento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import rh.javapleno.pagamento.controller.ProfissaoController;
import rh.javapleno.pagamento.enums.Situacao;
import rh.javapleno.pagamento.model.Profissao;
import rh.javapleno.pagamento.service.ProfissaoService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;

public class ProfissaoControllerTest {

    private Profissao profissao;
    @InjectMocks
    private ProfissaoController profissaoController;
    @Mock
    private ProfissaoService profissaoService;

    @BeforeEach
    void setUp() {

        profissao = new Profissao(3L,"Garcon", 120.0,Situacao.ATIVO);
    }

    @Test
    void deveSalvarProfissao(){
        when(profissaoService.salvar(profissao)).thenReturn(profissao);
        var response = assertDoesNotThrow(() ->profissaoController.salvar(profissao));
        assertNotNull(response);
        assertEquals(ResponseEntity.status(CREATED).body(profissao),response);


    }
}
