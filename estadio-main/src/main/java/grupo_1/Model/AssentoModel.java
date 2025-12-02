package grupo_1.Model;

import javax.persistence.*;

@Entity
@Table(name = "Assento")
public class AssentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ASSENTO")
    private Integer idAssento;

    @ManyToOne
    @JoinColumn(name = "ID_SETOR", referencedColumnName = "ID_SETOR")
    private SetorModel setor;

    public Integer getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(Integer idAssento) {
        this.idAssento = idAssento;
    }

    public SetorModel getSetor() {
        return setor;
    }

    public void setSetor(SetorModel setor) {
        this.setor = setor;
    }
}
