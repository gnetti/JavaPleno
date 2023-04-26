package rh.javapleno.email.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.email.model.Email;
import rh.javapleno.email.service.EmailService;

@RequestMapping("/email")
@RestController
@Tag(name = "Email")
public class EmailController {

  @Autowired
  public EmailService emailService;

  @Operation(summary = "Envio de email.")
  @PostMapping
  public Email enviarEmail(@RequestBody Email email) {
    return emailService.enviarEmail(email);
  }
}
