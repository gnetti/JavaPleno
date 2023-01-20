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
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.colaborador.service.RelatorioService;

@Slf4j
@RefreshScope
@RestController
@RequiredArgsConstructor
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    RelatorioService relatorioService;

    @GetMapping("/colaborador-total-pagar")
    public ResponseEntity<byte[]> relvalortotaldiastrabporcolab (){
       var relatorioGerado = relatorioService.gerarRelatorio();
        var headers = new HttpHeaders();
        var fileName = "colaborador-total.pdf";

        headers.setContentDispositionFormData("inline; filename=\""+fileName+ "\"",fileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        var responseEntity = new ResponseEntity<>(relatorioGerado, headers, HttpStatus.OK);
        return responseEntity;

    }
}
