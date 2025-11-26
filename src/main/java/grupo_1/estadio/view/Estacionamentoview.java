package grupo_1.estadio.view;

public package grupo_1.estadio.view;

import grupo_1.estadio.model.Estacionamento;
//
public class Estacionamentoview {

    private Long id;
    private String descricao;
    private Integer capacidade;

    public EstacionamentoView(Estacionamento estacionamento) {
        this.id = estacionamento.getId();
        this.descricao = estacionamento.getDescricao();
        this.capacidade = estacionamento.getCapacidade();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getCapacidade() {
        return capacidade;
    }
}
  
