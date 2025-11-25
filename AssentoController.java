import java.sql.Connection;
import java.util.List;

public class AssentoController {

    private AssentoDAO dao;

    public AssentoController(Connection conn) {
        this.dao = new AssentoDAO(conn);
    }

    public void criarAssento(int idAssento, int idSetor) throws Exception {
        Assento a = new Assento(idAssento, idSetor);
        dao.inserir(a);
    }

    public Assento buscarAssento(int id) throws Exception {
        return dao.buscarPorId(id);
    }

    public List<Assento> listarAssentos() throws Exception {
        return dao.listar();
    }

    public void atualizarAssento(int idAssento, int novoSetor) throws Exception {
        Assento a = new Assento(idAssento, novoSetor);
        dao.atualizar(a);
    }

    public void deletarAssento(int idAssento) throws Exception {
        dao.deletar(idAssento);
    }
}
