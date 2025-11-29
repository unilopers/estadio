import java.sql.Connection;
import java.util.List;

public class AssentoController {

    private final AssentoDAO assentoDAO;

    public AssentoController(Connection conn) {
        this.assentoDAO = new AssentoDAO(conn);
    }

    public boolean criarAssento(int idAssento, int idSetor) {
        try {
            // regra simples: garantir que setor não seja negativo
            if (idSetor <= 0) {
                System.out.println("Setor inválido!");
                return false;
            }

            Assento novo = new Assento(idAssento, idSetor);
            assentoDAO.inserir(novo);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao criar assento: " + e.getMessage());
            return false;
        }
    }

    public Assento buscarAssento(int idAssento) {
        try {
            return assentoDAO.buscarPorId(idAssento);
        } catch (Exception e) {
            System.out.println("Erro ao buscar assento: " + e.getMessage());
            return null;
        }
    }

    public List<Assento> listarAssentos() {
        try {
            return assentoDAO.listar();
        } catch (Exception e) {
            System.out.println("Erro ao listar assentos: " + e.getMessage());
            return null;
        }
    }

    public boolean atualizarAssento(int idAssento, int novoSetor) {
        try {
            if (novoSetor <= 0) {
                System.out.println("Setor inválido!");
                return false;
            }

            Assento atualizado = new Assento(idAssento, novoSetor);
            assentoDAO.atualizar(atualizado);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar assento: " + e.getMessage());
            return false;
        }
    }

    public boolean deletarAssento(int idAssento) {
        try {
            assentoDAO.deletar(idAssento);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao deletar assento: " + e.getMessage());
            return false;
        }
    }
}
