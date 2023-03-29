package rh.javapleno.email.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.email.model.Email;
import rh.javapleno.email.service.EmailService;

@RequestMapping("/email")
@RestController
public class EmailController {

  @Autowired
  public EmailService emailService;

  @PostMapping
  public Email enviarEmail(@RequestBody Email email) {
    return emailService.enviarEmail(email);
  }
}
