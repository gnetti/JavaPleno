package rh.javapleno.email.model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import rh.javapleno.email.enums.EmailStatus;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_email")
public class Email implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String messageId;
  private String emailFrom;
  private String emailTo;
  private String subject;
  private String text;
  @CreationTimestamp
  private LocalDateTime localDateTime;
  private EmailStatus emailStatus;

}
