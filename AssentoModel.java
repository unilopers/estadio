public class Assento {
    private int idAssento;
    private int idSetor;

    public Assento() {}

    public Assento(int idAssento, int idSetor) {
        this.idAssento = idAssento;
        this.idSetor = idSetor;
    }

    public int getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }
}
