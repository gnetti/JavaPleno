package rh.javapleno.colaborador.controller;


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
import rh.javapleno.colaborador.service.RelatorioService;
import rh.javapleno.colaborador.util.DateUtils;

import java.util.Date;

@Slf4j
@RefreshScope
@RestController
@RequiredArgsConstructor
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    RelatorioService relatorioService;

    @GetMapping("/colaborador-total-pagar")
    public ResponseEntity<byte[]> relvalortotaldiastrabporcolab(

            @RequestParam(value = "id", required = false, defaultValue = "") Long id,
            @RequestParam(value = "inicio", required = false, defaultValue = "") String inicio,
            @RequestParam(value = "fim", required = false, defaultValue = "") String fim

    ) {

        Date dataInicio = DateUtils.fromString(inicio);
        Date dataFim = DateUtils.fromString(fim, true);

        if (dataInicio == null) {
            dataInicio = DateUtils.DATA_INICIO_PADRAO;
        }
        if (dataFim == null) {
            dataFim = DateUtils.hoje(true);
        }

        var relatorioGerado = relatorioService.gerarRelatorio(id, dataInicio, dataFim);
        var headers = new HttpHeaders();
        var fileName = "colaborador-total.pdf";

        headers.setContentDispositionFormData("inline; filename=\"" + fileName + "\"", fileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        var responseEntity = new ResponseEntity<>(relatorioGerado, headers, HttpStatus.OK);
        return responseEntity;
    }
}
