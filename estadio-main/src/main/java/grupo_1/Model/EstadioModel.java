package grupo_1.Model;

import javax.persistence.*;


@Entity
@Table(name = "estadio")

public class EstadioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadio")
    private Integer id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
