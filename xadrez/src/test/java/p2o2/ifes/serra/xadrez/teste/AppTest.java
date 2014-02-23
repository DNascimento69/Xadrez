package p2o2.ifes.serra.xadrez.teste;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p2o2.ifes.serra.dao.DAOJogador;
import p2o2.ifes.serra.factory.JogadorFactory;
import p2o2.ifes.serra.factory.JogadorFactoryInterface;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Jogador;

public class AppTest {

    public DAOJogador DAO;

    @Before
    public void before() throws ClassNotFoundException, SQLException {
        DAO = new DAOJogador();
        criarTabelaJogador();
    }

    //@Test
    private void criarTabelaJogador() throws ClassNotFoundException,
            SQLException {

        // Criando a tabela
        DAO.criarTabela();
    }

    @Test
    public void salvarJogador() throws ClassNotFoundException, SQLException {
        
        

        JogadorFactoryInterface jfi = new JogadorFactory();
        Jogador jogador = jfi.getJogador("Pedro", EPlayerColor.white);

        // inserindo o usuario no banco de dados
        DAO.insert(jogador);
        Assert.assertNotSame(0, jogador.getId());

    }

    @Test
    public void buscarJogador() throws ClassNotFoundException, SQLException {
        JogadorFactoryInterface jfi = new JogadorFactory();
        Jogador usuario = jfi.getJogador("Pedro", EPlayerColor.white);

        DAO.insert(usuario);

        Jogador usuarioX = DAO.findbyID(usuario.getId());
        Assert.assertNotNull(usuarioX.getNome());

    }

    @Test
    public void deletarJogador() throws ClassNotFoundException, SQLException {
       JogadorFactoryInterface jfi = new JogadorFactory();
        Jogador usuario = jfi.getJogador("Pedro", EPlayerColor.white);

        DAO.insert(usuario);

        Jogador usuarioX = DAO.findbyID(usuario.getId());
        Assert.assertNotNull(usuarioX.getNome());

        this.DAO.delete(usuario);
        Assert.assertNull(this.DAO.findAll());


    }

    @Test
    public void listarJogadors() throws ClassNotFoundException, SQLException {

        JogadorFactoryInterface jfi = new JogadorFactory();
        Jogador usuario = jfi.getJogador("Pedro", EPlayerColor.white);
      
        Assert.assertNotNull(usuario);
        DAO.insert(usuario);
        
        Jogador usuario2 = jfi.getJogador("Marcos", EPlayerColor.black);
       Assert.assertNotNull(usuario2);

        DAO.insert(usuario2);

        List<Jogador> usuarios = DAO.findAll();

        Assert.assertNotNull(usuarios);

        Assert.assertNotSame(0, usuarios.size());
    }
}
