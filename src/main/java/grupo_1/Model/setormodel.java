ackage com.seuprojeto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Setor")
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SETOR")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADIO", referencedColumnName = "ID_ESTADIO")
    private Estadio estadio;

    @Column(name = "NOME", length = 100)
    private String nome;

    public Setor() {}

    public Setor(Integer id, Estadio estadio, String nome) {
        this.id = id;
        this.estadio = estadio;
        this.nome = nome;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Estadio getEstadio() { return estadio; }
    public void setEstadio(Estadio estadio) { this.estadio = estadio; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
