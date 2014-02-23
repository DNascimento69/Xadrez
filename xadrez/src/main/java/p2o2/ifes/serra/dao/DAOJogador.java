package p2o2.ifes.serra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import p2o2.ifes.serra.model.cdp.Jogador;

public class DAOJogador extends DAOGeneric implements DAO<Jogador> {

    public DAOJogador() throws SQLException, ClassNotFoundException {
        //this.openConnection();
    }

    //CRIANDO A TABELA Jogador
    public void criarTabela() throws ClassNotFoundException, SQLException {
        this.openConnection();

        this.execute("DROP TABLE IF EXISTS Jogador CASCADE");

        String sql = "CREATE TABLE Jogador "
                + "("
                + " ID serial NOT NULL, "
                + " nome character varying(100) , "
                + " pontos integer , "
                + " CONSTRAINT primaryKey PRIMARY KEY (id);";




        //System.out.println(sql);
        this.execute(sql);

        this.closeConnection();
    }

    public void insert(Jogador obj) throws SQLException, ClassNotFoundException {

        this.openConnection();

        String sql = "INSERT INTO Jogador (nome, pontos)"
                + " VALUES ('" + obj.getNome() + "'," + obj.getPontos() + ")";

        int id = this.executeUpdate(sql);

        obj.setId(id);

        this.closeConnection();

    }

    public void update(Jogador obj) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub

        this.openConnection();

        String sql = "UPDATE Jogador"
                + " SET nome = '" + obj.getNome()
                + "' , pontos = " + obj.getPontos()
                + "' Where ID = " + obj.getId();

        // System.out.println(sql);
        int id = this.executeUpdate(sql);

        obj.setId(id);

        this.closeConnection();

    }

    public void delete(Jogador obj) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub

        this.openConnection();

        String sql = "DELETE FROM Jogador" + "Where ID = " + obj.getId();

        int id = this.executeUpdate(sql);

        obj.setId(id);

        this.closeConnection();


    }

    public Jogador findbyID(int id) throws ClassNotFoundException, SQLException {
        //Query para buscar o card
        this.openConnection();

        String sql = "SELECT * FROM Jogador WHERE ID =" + id;

        ResultSet rs = this.executeQuery(sql);

        List<Jogador> cards = retriveJogadors(rs);

        this.closeConnection();

        return cards.get(0);
    }

    public List<Jogador> findAll() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
      this.openConnection();

        String sql = "SELECT * FROM Jogador ";

        ResultSet rs = this.executeQuery(sql);

        List<Jogador> cards = retriveJogadors(rs);

       this.closeConnection();

        return cards;
    }

    //fazer primeiro jogador Dao
    private List<Jogador> retriveJogadors(ResultSet rs) throws SQLException {
        List<Jogador> jogadoreslist = new ArrayList<Jogador>();

        while (rs.next()) {
            Jogador j = new Jogador();

            j.setId(rs.getInt("ID"));

            j.setNome(rs.getString("nome"));
            
            j.setPontos(rs.getInt("pontos"));
            
            jogadoreslist.add(j);
        }

        return jogadoreslist;
    }

    public Jogador create() {
        return new Jogador();
    }

	public Jogador findbyID(Long id) throws SQLException, ClassNotFoundException {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}