package grupo_1.estadio.model;

public package grupo_1.estadio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estacionamento")
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Integer capacidade;

    public Estacionamento() {}

    public Estacionamento(String descricao, Integer capacidade) {
        this.descricao = descricao;
        this.capacidade = capacidade;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
}
