package grupo_1.dto;

public class UsuarioFuncionarioDTO {
    private Integer idUsuario;
    private String nome;
    private String username;
    private String email;

    public UsuarioFuncionarioDTO() {
    }

    public UsuarioFuncionarioDTO(Integer idUsuario, String nome, String username, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.username = username;
        this.email = email;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
