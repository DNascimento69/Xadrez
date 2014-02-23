package p2o2.ifes.serra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.Enum.EStatusPeca;
import p2o2.ifes.serra.model.cdp.Peca;

public class DAOPeca extends DAOGeneric implements DAO<Peca> {

	public DAOPeca() throws SQLException, ClassNotFoundException {
		//this.openConnection();
	}

	//CRIANDO A TABELA Peca
	public void criarTabela() throws ClassNotFoundException, SQLException {
		this.openConnection();

		this.execute("DROP TABLE IF EXISTS Peca CASCADE");

		String sql = "CREATE TABLE Peca "
				+ "("
				+ " ID serial NOT NULL, "
				+ " idGame integer , "
				+ " statusPeca character varying(10)"
				+ " pecaId character varying(10)"
				+ " cor character varying(10), "
				+ " posicao character varying(20)"
				+ " valor integer , "
				+ " CONSTRAINT primaryKey PRIMARY KEY (id),"
				+ " CONSTRAINT idGame_foreignKey FOREIGN KEY (idGame)"
				+ " REFERENCES Game (ID) MATCH SIMPLE"
				+ " ON UPDATE NO ACTION ON DELETE NO ACTION;";




		//System.out.println(sql);
		this.execute(sql);

		this.closeConnection();
	}

	public void insert(Peca obj) throws SQLException, ClassNotFoundException {

		this.openConnection();

		String sql = "INSERT INTO Peca (idGame, statusPeca, pecaId, valor, posicao, cor)"
				+ " VALUES (" + obj.getIdGame() + ",'" + obj.getStatusPeca() + "','" + obj.getPecaId() + "', "
				+ obj.getValor() + " , '" + obj.getPosicao() + "', '" + obj.getCor() + "')";

		int id = this.executeUpdate(sql);

		obj.setId(id);

		this.closeConnection();

	}

	public void update(Peca obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		this.openConnection();

		String sql = "UPDATE Peca"
				+ " SET valor = " + obj.getValor()
				+ " , posicao = '" + obj.getPosicao()
				+ "' , cor = '" + obj.getCor()
				+ "' , idGame = " + obj.getIdGame()
				+ " , statusPeca = '" + obj.getStatusPeca()
				+ "' , pecaId = '" + obj.getPecaId()
				+ "' Where ID = " + obj.getId();

		// System.out.println(sql);
		int id = this.executeUpdate(sql);

		obj.setId(id);

		this.closeConnection();

	}

	public void delete(Peca obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		this.openConnection();

		String sql = "DELETE FROM Peca" + "Where ID = " + obj.getId();

		int id = this.executeUpdate(sql);

		obj.setId(id);

		this.closeConnection();


	}

	public List<Peca> findByIdGame(int idGame) throws SQLException, ClassNotFoundException {
		this.openConnection();

		String sql = "SELECT * FROM Peca WHERE idGame = " + idGame;

		ResultSet rs = this.executeQuery(sql);

		List<Peca> list = retrivePecas(rs);

		this.closeConnection();
		return list;

	}

	public Peca findbyID(Long id) throws ClassNotFoundException, SQLException {
		//Query para buscar o peca
		this.openConnection();

		String sql = "SELECT * FROM Peca WHERE ID =" + id;

		ResultSet rs = this.executeQuery(sql);

		List<Peca> cards = retrivePecas(rs);

		this.closeConnection();

		return cards.get(0);
	}

	public List<Peca> findAll() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		this.openConnection();

		String sql = "SELECT * FROM Peca ";

		ResultSet rs = this.executeQuery(sql);

		List<Peca> cards = retrivePecas(rs);

		this.closeConnection();

		return cards;
	}

	//fazer primeiro jogador Dao
	private List<Peca> retrivePecas(ResultSet rs) throws SQLException {
		List<Peca> pecaslist = new ArrayList<Peca>();

		while (rs.next()) {
			Peca p = new Peca();

			p.setId(rs.getInt("ID"));

			if (rs.getString("statusPeca").equals(EStatusPeca.morto)) {
				p.setStatusPeca(EStatusPeca.morto);
			} else {
				p.setStatusPeca(EStatusPeca.vivo);
			}

			p.setPecaId(rs.getString("pecaId"));

			p.setIdGame(rs.getInt("idGame"));

			p.setValor(rs.getInt("valor"));

			p.setPosicao(rs.getString("posicao"));

			if (rs.getString("cor").equals("black")) {
				p.setCor(EPlayerColor.black);
			} else {
				p.setCor(EPlayerColor.white);
			}


			pecaslist.add(p);
		}

		return pecaslist;
	}

	public Peca create() {
		return new Peca();
	}
}