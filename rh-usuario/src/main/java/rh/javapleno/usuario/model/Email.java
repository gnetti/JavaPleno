package rh.javapleno.usuario.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rh.javapleno.usuario.enums.EmailStatus;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    private long id;
    private String messageId;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private LocalDateTime localDateTime;
    private EmailStatus emailStatus;
}
