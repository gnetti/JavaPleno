package rh.javapleno.email.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rh.javapleno.email.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
