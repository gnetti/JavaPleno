package rh.javapleno.pagamento.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionPadrao {

    private Integer status;
    private Long timestamp;
    private String message;


}
