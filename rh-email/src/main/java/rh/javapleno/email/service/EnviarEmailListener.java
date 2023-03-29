package rh.javapleno.email.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import rh.javapleno.email.config.RabbitConfig;
import rh.javapleno.email.model.Email;

@Slf4j
@Component
public class EnviarEmailListener {

  @Autowired
  private EmailService emailService;


  @RabbitListener(queues = RabbitConfig.CRIAR) // consumer
  public void listenerCriar(@Payload Email email) {
    log.info("paylod Criar: {}", email);
    emailService.enviarEmail(email);
  }

  @RabbitListener(queues = RabbitConfig.ALTERAR) // consumer
  public void listenerAlterar(@Payload Email email) {
    log.info("paylod Alterar: {}", email);
    emailService.enviarEmail(email);
  }

  @RabbitListener(queues = RabbitConfig.EXCLUIR) // consumer
  public void listenerExcluir(@Payload Email email) {
    log.info("paylod Excluir: {}", email);
    emailService.enviarEmail(email);
  }
}
