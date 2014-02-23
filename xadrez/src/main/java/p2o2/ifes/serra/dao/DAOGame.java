package p2o2.ifes.serra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import p2o2.ifes.serra.model.Enum.EGameStatus;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Game;

public class DAOGame extends DAOGeneric implements DAO<Game> {

    public DAOGame() throws SQLException, ClassNotFoundException {
        //this.openConnection();
    }

    //CRIANDO A TABELA Game
    public void criarTabela() throws ClassNotFoundException, SQLException {
        this.openConnection();

        this.execute("DROP TABLE IF EXISTS Game CASCADE");

        String sql = "CREATE TABLE Game "
                + "("
                + " ID serial NOT NULL, "
                + " Jogador1_id bigint , "
                + " Jogador2_id bigint , "
                + " jogadorDaVez character varying(100) "
                + " statusJogo character varying(100),"
                + " CONSTRAINT primaryKay_game PRIMARY KEY (ID)) "
                + " CONSTRAINT jogador1_foreignKey FOREIGN KEY (Jogador1_id)"
                + " REFERENCES Jogador (id) MATCH SIMPLE"
                + " ON UPDATE NO ACTION ON DELETE NO ACTION,"
                + " CONSTRAINT jogador2_foreignKey FOREIGN KEY (Jogador2_id)"
                + " REFERENCES Jogador (id) MATCH SIMPLE"
                + " ON UPDATE NO ACTION ON DELETE NO ACTION;";




        //System.out.println(sql);
        this.execute(sql);

        this.closeConnection();
    }

    public void insert(Game obj) throws SQLException, ClassNotFoundException {

        this.openConnection();

        String sql = "INSERT INTO Game (Jogador1_id, Jogador2_id, jogadorDaVez, statusJogo)"
                + " VALUES (" + obj.getJogador1().getId() + "," + obj.getJogador2().getId() + "," + " ,'"
                + obj.getJogadorDaVez() + "',' " + obj.getGameStatus() + "')";

        int id = this.executeUpdate(sql);

        obj.setId(id);

        this.closeConnection();

    }

    public void update(Game obj) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub

        this.openConnection();

        String sql = "UPDATE Game"
                + " SET Jogador1_id = " + obj.getJogador1().getId()
                + " , Jogador2_id = " + obj.getJogador2().getId()
                + " , jogadorDaVez = '" + obj.getJogadorDaVez()
                + "', statusJogo =" + obj.getGameStatus()
                + "' Where ID = " + obj.getId();

        // System.out.println(sql);
        int id = this.executeUpdate(sql);

        obj.setId(id);

        this.closeConnection();

    }

    public void delete(Game obj) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub

        this.openConnection();

        String sql = "DELETE FROM Game" + "Where ID = " + obj.getId();

        int id = this.executeUpdate(sql);

        obj.setId(id);

        this.closeConnection();


    }

    public Game findbyID(int id) throws ClassNotFoundException, SQLException {
        //Query para buscar o card
        this.openConnection();

        String sql = "SELECT * FROM Game WHERE ID =" + id;

        ResultSet rs = this.executeQuery(sql);

        List<Game> cards = retriveGames(rs);

        this.closeConnection();

        return cards.get(0);
    }

    public List<Game> findAll() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        this.openConnection();

        String sql = "SELECT * FROM Game ";

        ResultSet rs = this.executeQuery(sql);

        List<Game> cards = retriveGames(rs);

        this.closeConnection();

        return cards;
    }

 // nao está completo precisa criar o DAOTabuleiro e buscar por id, igual foi feito com os jogadores
    private List<Game> retriveGames(ResultSet rs) throws SQLException, ClassNotFoundException {
        List<Game> gameslist = new ArrayList<Game>();
        DAOJogador j = new DAOJogador();  
        while (rs.next()) {
            Game game = new Game();

            game.setId(rs.getInt("ID"));
               
            
            game.setJogador1(j.findbyID(rs.getLong("Jogador1_id")));
            
            game.setJogador2(j.findbyID(rs.getLong("Jogador2_id")));
            
            if(rs.getString("jogadorDaVez").equals("black")){
                game.setJogadorDaVez(EPlayerColor.black);
            } else game.setJogadorDaVez(EPlayerColor.white);
            
            if(rs.getString("statusJogo").equals("Terminado")){
                game.setGameStatus(EGameStatus.Terminado);
                
            }else game.setGameStatus(EGameStatus.EmAndamento);
            
            // add tabuleiro a game
                  
            

            gameslist.add(game);
        }

        return gameslist;
    }

    public Game create() {
        return new Game();
    }

	public Game findbyID(Long id) throws SQLException, ClassNotFoundException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}