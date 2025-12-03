package grupo_1.Model;

import javax.persistence.*;

@Entity
@Table(name = "Setor")
public class SetorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SETOR")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADIO", referencedColumnName = "ID_ESTADIO")
    private EstadioModel estadio;

    @Column(name = "NOME", length = 100)
    private String nome;

    public SetorModel() {}

    public SetorModel(Integer id, EstadioModel estadio, String nome) {
        this.id = id;
        this.estadio = estadio;
        this.nome = nome;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public EstadioModel getEstadio() { return estadio; }
    public void setEstadio(EstadioModel estadio) { this.estadio = estadio; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
