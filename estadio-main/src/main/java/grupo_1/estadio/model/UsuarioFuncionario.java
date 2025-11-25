package grupo_1.estadio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Usuario_Funcionario")
@Data
public class UsuarioFuncionario {

    @Id
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ID_FUNCIONARIO")
    private Integer idFuncionario;
}
