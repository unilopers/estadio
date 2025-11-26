package group_1.estadio.ingresso;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ingressos")
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoIngresso;
    private BigDecimal precoVenda;
    private LocalDateTime dataEmissao;
    private Boolean isUtilizado = false;

}