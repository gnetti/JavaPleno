package rh.javapleno.pagamento.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.pagamento.service.RelatorioService;
import rh.javapleno.pagamento.util.DateUtils;

import java.util.Date;

@Slf4j
@RefreshScope
@RestController
@RequiredArgsConstructor
@RequestMapping("/relatorio")
@Tag(name = "Relatório")
public class RelatorioController {

    @Autowired
    RelatorioService relatorioService;

    @Operation(summary = "Relatório dias trabalhados.")
    @GetMapping("/colaborador-total-pagar")
    public ResponseEntity<byte[]> relvalortotaldiastrabporcolab(

            @RequestParam(value = "id", required = false, defaultValue = "") Long id,
            @RequestParam(value = "inicio", required = false, defaultValue = "") String inicio,
            @RequestParam(value = "fim", required = false, defaultValue = "") String fim

    ) {

        Date dataInicio = DateUtils.fromString(inicio);
        Date dataFim = DateUtils.fromString(fim, true);

        if(dataInicio == null){
            dataInicio = DateUtils.DATA_INICIO_PADRAO;
        }
        if(dataFim==null){
            dataFim = DateUtils.hoje(true);
        }

        var relatorioGerado = relatorioService.gerarRelatorioRelvalortotaldiastrabporcolab(id, dataInicio, dataFim);
        var headers = new HttpHeaders();
        var fileName = "colaborador-total-pagar.pdf";

        headers.setContentDispositionFormData("inline; filename=\"" + fileName + "\"", fileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        var responseEntity = new ResponseEntity<>(relatorioGerado, headers, HttpStatus.OK);
        return responseEntity;

    }

    @Operation(summary = "Relatório pagamento.")
    @GetMapping("/lista-colaborador-total-pagar")
    public ResponseEntity<byte[]> relvalortotaldiastrabagrupaporcolab(

            @RequestParam(value = "inicio", required = false, defaultValue = "") String inicio,
            @RequestParam(value = "fim", required = false, defaultValue = "") String fim

    ) {

        Date dataInicio = DateUtils.fromString(inicio);
        Date dataFim = DateUtils.fromString(fim, true);

        if(dataInicio == null){
            dataInicio = DateUtils.DATA_INICIO_PADRAO;
        }
        if(dataFim==null){
            dataFim = DateUtils.hoje(true);
        }

        var relatorioGerado = relatorioService.gerarRelatorioRelvalortotaldiastrabporcolab(dataInicio, dataFim);
        var headers = new HttpHeaders();
        var fileName = "lista-colaborador-total-pagar.pdf";

        headers.setContentDispositionFormData("inline; filename=\"" + fileName + "\"", fileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        var responseEntity = new ResponseEntity<>(relatorioGerado, headers, HttpStatus.OK);
        return responseEntity;

    }
}
