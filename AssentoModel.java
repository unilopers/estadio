/**
 * Representa um assento dentro de um setor do estádio.
 */
public class Assento {

    private int idAssento;
    private int idSetor;

    public Assento() {}

    public Assento(int idAssento, int idSetor) {
        setIdAssento(idAssento);
        setIdSetor(idSetor);
    }

    public int getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(int idAssento) {
        if (idAssento <= 0) {
            throw new IllegalArgumentException("ID do assento deve ser maior que zero.");
        }
        this.idAssento = idAssento;
    }

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        if (idSetor <= 0) {
            throw new IllegalArgumentException("ID do setor deve ser maior que zero.");
        }
        this.idSetor = idSetor;
    }

    @Override
    public String toString() {
        return "Assento{" +
                "idAssento=" + idAssento +
                ", idSetor=" + idSetor +
                '}';
    }
}
