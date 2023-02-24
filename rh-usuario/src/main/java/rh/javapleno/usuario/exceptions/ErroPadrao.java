package rh.javapleno.usuario.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErroPadrao {

    private Integer status;
    private Long timestamp;
    private String message;


}
